package api

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"math/rand"
	"net/http"
	"net/http/httputil"
	"net/url"
	"strings"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/gaozhen1996/pig-cloud/pkg/setting"
	"github.com/gin-gonic/gin"
)

type Service struct {
	Address     string
	ServicePort int
}

type TargetService struct {
	ResouceUrl string
	HostPort   string
}

func Router(c *gin.Context) {
	target := gateWayRouter(c.Request.URL.Path)
	logging.Info(target)
	u, _ := url.Parse(c.Request.URL.String())

	var proxy = httputil.ReverseProxy{
		Director: func(req *http.Request) {
			req.URL.Scheme = "http"
			req.URL.Host = target.HostPort
			req.URL.RawQuery = u.RawQuery
			req.URL.Path = target.ResouceUrl
			req.Host = target.HostPort
			req.Header = c.Request.Header
		},
	}

	proxy.ErrorHandler = func(rw http.ResponseWriter, req *http.Request, err error) {
		ret := fmt.Sprintf("http proxy error %v", err)
		logging.Info(ret)
		rw.Write([]byte(ret))
	}

	proxy.ServeHTTP(c.Writer, c.Request)

	c.Next()
}

func gateWayRouter(url string) TargetService {
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
	 * 获取需要路由的服务和IP
	 */
	service := getHostByName(serviceName)
	/**
	 * 请求转发
	 */
	hostPort := fmt.Sprintf("%s:%d", service.Address, service.ServicePort)

	targetService := TargetService{
		ResouceUrl: resouceUrl,
		HostPort:   hostPort,
	}

	return targetService
}

/**
 *从consul中加载host和port
 */
func getHostByName(name string) Service {
	url := "http://" + setting.ConsulHost + "/v1/catalog/service/" + name
	resp, _ := http.Get(url)
	body, _ := ioutil.ReadAll(resp.Body)
	defer resp.Body.Close()

	var services []Service
	_ = json.Unmarshal([]byte(body), &services)
	if len(services) > 0 {
		var index = rand.Intn(len(services))
		return services[index]
	} else {
		logging.Error(name + "没有在注册中心中发现\n" + string(body))
		s := Service{
			Address:     "",
			ServicePort: 0,
		}
		return s
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
