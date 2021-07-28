package setting

import (
	"encoding/base64"
	"encoding/json"
	"io/ioutil"
	"net/http"
	"os"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
)

type Consul_KV struct {
	Key   string
	Value string
}

func LoadConfigCenter(host, configCenterUrl string) string {

	url := "http://" + host + "/v1/kv/" + configCenterUrl
	resp, _ := http.Get(url)
	body, _ := ioutil.ReadAll(resp.Body)
	defer resp.Body.Close()

	var kvArr []Consul_KV
	_ = json.Unmarshal([]byte(body), &kvArr)

	// 对上面的编码结果进行base64解码
	decodeBytes, err := base64.StdEncoding.DecodeString(kvArr[0].Value)
	if err != nil {
		logging.Error("读取配置中心解码出错：" + err.Error())
	}

	//将配置中心字符串写入文件
	fileName := "conf/application.ini"
	iniFile, err := os.Create(fileName)
	if err != nil {
		logging.Error("读取配置中心文件出错：" + err.Error())
	}
	defer iniFile.Close()
	iniFile.WriteString(string(decodeBytes))

	return fileName
}
