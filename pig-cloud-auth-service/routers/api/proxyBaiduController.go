package api

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"

	"github.com/gaozhen1996/pig-cloud/pkg/e"
	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/gin-gonic/gin"
)

type SerchWord struct {
	Account string
	Wd      string
}

type SerchResultResponse struct {
	Q string
}

type BaiDuResponse struct {
	G []SerchResultResponse
}

func LoadWd(c *gin.Context) {
	code := e.SUCCESS
	request := SerchWord{}
	c.BindJSON(&request)
	logging.Info(fmt.Sprintln("SeachWord{account:" + request.Account + ",wd:" + request.Wd + "}"))
	res, _ := http.Get("https://www.baidu.com/sugrec?prod=pc&wd=" + request.Wd)
	body, _ := ioutil.ReadAll(res.Body)
	returnData := BaiDuResponse{}
	json.Unmarshal(body, &returnData)
	c.JSON(http.StatusOK, gin.H{
		"code": code,
		"msg":  e.GetMsg(code),
		"data": returnData.G,
	})
}
