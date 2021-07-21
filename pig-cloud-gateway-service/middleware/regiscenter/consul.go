package regiscenter

import (
	"fmt"
	"log"
	"net"

	"github.com/gaozhen1996/pig-cloud/pkg/setting"
	consulapi "github.com/hashicorp/consul/api"
)

func RegisterServer() {
	consul_setting, _ := setting.Cfg.GetSection("consul")

	config := consulapi.DefaultConfig()
	config.Address = consul_setting.Key("consul_host").String()
	client, err := consulapi.NewClient(config)

	if err != nil {
		log.Fatal("consul client error : ", err)
	}

	registration := new(consulapi.AgentServiceRegistration)
	registration.Address = localIP()                                                                                          // 服务 IP
	registration.ID = fmt.Sprintf("%s-%s-%d", consul_setting.Key("node_id").String(), registration.Address, setting.HTTPPort) // 服务节点id
	registration.Name = consul_setting.Key("server_name").String()                                                            // 服务名称
	registration.Port = setting.HTTPPort                                                                                      // 服务端口
	//registration.Tags = []string{"v1000"} // tag，可以为空
	checkPort := setting.HTTPPort
	registration.Check = &consulapi.AgentServiceCheck{ // 健康检查
		HTTP:                           fmt.Sprintf("http://%s:%d%s", registration.Address, checkPort, "/check"),
		Timeout:                        consul_setting.Key("timeout").String(),
		Interval:                       consul_setting.Key("interval").String(), // 健康检查间隔
		DeregisterCriticalServiceAfter: "30s",                                   //check失败后30秒删除本服务，注销时间，相当于过期时间
		// GRPC:     fmt.Sprintf("%v:%v/%v", IP, r.Port, r.Service),// grpc 支持，执行健康检查的地址，service 会传到 Health.Check 函数中
	}

	err = client.Agent().ServiceRegister(registration)
	if err != nil {
		log.Fatal("register server error : ", err)
	}

	//http.HandleFunc("/check", consulCheck)
	//http.ListenAndServe(fmt.Sprintf(":%d", checkPort), nil)
}

func localIP() string {
	addrs, err := net.InterfaceAddrs()
	if err != nil {
		return ""
	}
	for _, address := range addrs {
		if ipnet, ok := address.(*net.IPNet); ok && !ipnet.IP.IsLoopback() {
			if ipnet.IP.To4() != nil {
				return ipnet.IP.String()
			}
		}
	}
	return ""
}
