package service

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/gaozhen1996/pig-cloud/pkg/setting"
)

type CachePool struct {
	roundRuleMap map[string]RoundRule //轮询规则缓存,key:服务名
	serviceMap   map[string][]Server  //服务实例缓存,key:服务名
}

//缓存池实例
var cachePool CachePool

func (cp *CachePool) GetRoundRule(serviceName string) RoundRule {

	//如果map中为空，则初始化
	if len(cp.roundRuleMap) == 0 {
		cp.roundRuleMap = make(map[string]RoundRule)
	}

	return cp.roundRuleMap[serviceName]
}

func (cp *CachePool) GetService(serviceName string) []Server {

	//如果map中为空，则初始化
	if len(cp.serviceMap) == 0 {
		cp.serviceMap = make(map[string][]Server)
	}
	var servers = cp.serviceMap[serviceName]
	fmt.Println()
	if len(servers) == 0 {
		servers = getHostFromRegister(serviceName)
		cp.serviceMap[serviceName] = servers
	}

	return servers
}

func ReloadServiceList(serviceName string) []Server {
	var services = getHostFromRegister(serviceName)
	cachePool.serviceMap[serviceName] = services
	return services
}

/**
 *从consul中加载host和port
 */
func getHostFromRegister(name string) []Server {
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
