package service

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"strings"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/gaozhen1996/pig-cloud/pkg/setting"
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
	servers := getHostByName(serviceName)
	/**
	 *根据路由规则来路由
	 */
	loadBalancer := &RoundRule{}
	loadBalancer.apiName = apiName
	server := loadBalancer.Choose(servers)
	/**
	 * 请求转发
	 */
	hostPort := fmt.Sprintf("%s:%d", server.Address, server.ServicePort)

	targetService := TargetService{
		ResouceUrl: resouceUrl,
		HostPort:   hostPort,
	}

	return targetService
}

/**
 *从consul中加载host和port
 */
func getHostByName(name string) []Server {
	url := "http://" + setting.ConsulHost + "/v1/catalog/service/" + name
	resp, _ := http.Get(url)
	body, _ := ioutil.ReadAll(resp.Body)
	defer resp.Body.Close()

	var servers []Server
	_ = json.Unmarshal([]byte(body), &servers)
	if len(servers) > 0 {
		return servers
	} else {
		logging.Error(name + "没有在注册中心中发现\n" + string(body))
		s := Server{
			Address:     "",
			ServicePort: 0,
		}
		servers = append(servers, s)
		return servers
	}

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
