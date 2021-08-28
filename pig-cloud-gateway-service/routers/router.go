package routers

import (
	"fmt"
	"net/http"

	"github.com/gaozhen1996/pig-cloud/pkg/setting"
	"github.com/gaozhen1996/pig-cloud/routers/api"
	"github.com/gin-gonic/gin"
)

func InitRouter() *gin.Engine {
	r := gin.New()

	r.Use(gin.Logger())
	r.Use(gin.Recovery())
	gin.SetMode(setting.RunMode)

	/*
	 * consul 心跳检查
	 */
	r.GET("/check", func(c *gin.Context) {
		fmt.Fprintln(c.Writer, "{'status':'UP'}")
	})

	api.SentinelInit()
	api.CreateFlowRule("FlowLimit", 500, 100)
	r.Use(handleRequest)

	return r
}

func handleRequest(c *gin.Context) {
	method := c.Request.Method

	c.Header("Access-Control-Allow-Origin", "*")
	c.Header("Access-Control-Allow-Headers", "Content-Type,AccessToken,X-CSRF-Token, Authorization, Token")
	c.Header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE,UPDATE") //服务器支持的所有跨域请求的方
	c.Header("Access-Control-Expose-Headers", "Content-Length, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Content-Type")
	c.Header("Access-Control-Allow-Credentials", "true")

	//放行所有OPTIONS方法
	if method == "OPTIONS" {
		c.AbortWithStatus(http.StatusNoContent)
		c.Next()
	} else {
		api.FlowLimit(c)
	}

}
