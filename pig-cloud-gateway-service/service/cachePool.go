package service

import (
	"encoding/json"
	"io/ioutil"
	"net/http"
	"sync"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/gaozhen1996/pig-cloud/pkg/setting"
)

type CachePool struct {
	roundRuleMap sync.Map            //轮询规则缓存,key:服务名
	serviceMap   map[string][]Server //服务实例缓存,key:服务名
}

//缓存池实例
var cachePool CachePool

func (cp *CachePool) GetRoundRule(serviceName string) RoundRule {
	var res RoundRule
	var rr, ok = cp.roundRuleMap.Load(serviceName)
	if ok {
		res = rr.(RoundRule)
	}
	return res
}

func (cp *CachePool) GetService(serviceName string) []Server {

	//如果map中为空，则初始化
	if len(cp.serviceMap) == 0 {
		cp.serviceMap = make(map[string][]Server)
	}
	var servers = cp.serviceMap[serviceName]
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
