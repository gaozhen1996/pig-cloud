package service

import (
	"fmt"
	"strconv"
	"strings"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/gaozhen1996/pig-cloud/pkg/setting"
	"github.com/gaozhen1996/pig-cloud/pkg/util"
)

type TargetService struct {
	ResouceUrl string
	HostPort   string
}

func GateWayRouter(url string) TargetService {
	/**
	 *解析URL
	 */
	start := 1                             //第一个斜杠
	end := strings.Index(url[1:], "/") + 1 //第二个斜杠
	apiName := url[start:end]
	resouceUrl := url[end:]

	/**
	 *根据api加载路由规则
	 */
	serviceName := loadRouterRule(apiName)
	/**
	 * 从注册中心中获取需要路由的服务和IP
	 */
	server := getHostByServiceName(serviceName)
	/**
	 * 请求转发
	 */
	hostPort := fmt.Sprintf("%s:%d", server.ServiceAddress, server.ServicePort)

	targetService := TargetService{
		ResouceUrl: resouceUrl,
		HostPort:   hostPort,
	}

	return targetService
}

/**
 *从consul中加载host和port,并根据路由规则来选择一个服务
 */
func getHostByServiceName(name string) Server {
	var services = cachePool.GetService(name)
	/**
	 *根据路由规则来路由
	 */
	loadBalancer := &RoundRule{}
	loadBalancer.apiName = name
	var server = loadBalancer.Choose(services)
	if !util.Telnet(server.ServiceAddress, strconv.Itoa(server.ServicePort)) {
		//如果有服务不可以，则更新一下缓存中的服务列表,并重新路由
		services = ReloadServiceList(name)
		server = loadBalancer.Choose(services)
	}
	return server
}

/**
 *加载路由规则
 */
func loadRouterRule(apiName string) string {
	routerCfg, err := setting.Cfg.GetSection("routes")
	if err != nil {
		logging.Error("load router rules fail")
	}
	serviceName := routerCfg.Key(apiName).String()
	if len(serviceName) == 0 {
		logging.Error(apiName + "没有配置路由规则")
	}
	return serviceName
}
