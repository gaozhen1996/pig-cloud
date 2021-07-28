package setting

import (
	"log"
	"os"
	"time"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/go-ini/ini"
)

var (
	BootCfg *ini.File
	Cfg     *ini.File
	RunMode string

	HTTPPort     int
	ReadTimeout  time.Duration
	WriteTimeout time.Duration

	JwtSecret  string
	ExpireTime int

	ConsulHost string
	ConfigUrl  string
)

func init() {
	var err error
	//加载引导配置文件
	BootCfg, err = ini.Load("conf/bootstrap.ini")
	if err != nil {
		logging.Error("Fail to parse 'conf/bootstrap.ini': %v", err)
	}
	LoadConsul()

	//加载配置中心的配置文件,加载完成后删掉
	var configCenterFile = LoadConfigCenter(ConsulHost, ConfigUrl)
	Cfg, err = ini.Load(configCenterFile)
	if err != nil {
		logging.Error("Fail to parse %s: %v", configCenterFile, err)
	}
	os.Remove(configCenterFile)

	LoadServer()
	LoadApp()

}

func LoadServer() {
	sec, err := Cfg.GetSection("server")
	if err != nil {
		log.Fatalf("Fail to get section 'server': %v", err)
	}

	HTTPPort = sec.Key("HTTP_PORT").MustInt(8000)
	RunMode = sec.Key("RUN_MODE").MustString("debug")
	ReadTimeout = time.Duration(sec.Key("READ_TIMEOUT").MustInt(60)) * time.Second
	WriteTimeout = time.Duration(sec.Key("WRITE_TIMEOUT").MustInt(60)) * time.Second
}

func LoadApp() {
	JwtSecret = "23647$666888"
	ExpireTime = 12
}

func LoadConsul() {
	sec, err := BootCfg.GetSection("consul")
	if err != nil {
		log.Fatalf("Fail to get section 'consul': %v", err)
	}

	ConsulHost = sec.Key("consul_host").MustString("127.0.0.1:8500")
	ConfigUrl = sec.Key("config_url").MustString("pig-cloud/pig-cloud-auth-service/app")
}
