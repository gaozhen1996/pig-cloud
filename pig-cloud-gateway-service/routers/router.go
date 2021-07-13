package routers

import (
	"github.com/gaozhen1996/pig-cloud/middleware/regiscenter"
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
	r.GET("/check", regiscenter.ConsulCheck)
	regiscenter.RegisterServer()

	r.Use(api.Router)

	return r
}
