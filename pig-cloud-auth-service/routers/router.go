package routers

import (
	"fmt"
	"net/http"

	_ "github.com/gaozhen1996/pig-cloud/docs"
	"github.com/gaozhen1996/pig-cloud/middleware/jwt"
	"github.com/gaozhen1996/pig-cloud/middleware/regiscenter"
	"github.com/gaozhen1996/pig-cloud/pkg/setting"
	"github.com/gaozhen1996/pig-cloud/routers/api"
	"github.com/gin-gonic/gin"
	ginSwagger "github.com/swaggo/gin-swagger"
	"github.com/swaggo/gin-swagger/swaggerFiles"
)

func InitRouter() *gin.Engine {
	r := gin.New()

	r.Use(gin.Logger())
	r.Use(gin.Recovery())
	gin.SetMode(setting.RunMode)
	/*
	 * swagger
	 */
	r.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerFiles.Handler))
	/*
	 * consul 心跳检查
	 */
	r.GET("/check", regiscenter.ConsulCheck)
	regiscenter.RegisterServer()
	/*
	 * 权限：远程方法
	 */
	r.GET("/isAuthenticated", func(c *gin.Context) {
		fmt.Println("header \r\n", c.Request.Header)
		c.String(http.StatusOK, "true")

	})
	/*
	 * 获取用户打开newTab的次数
	 */
	r.GET("/userActivityRest/listNewTabCountByDate", api.ListNewTabCountByDate)
	/*
	 * 加载百度的搜索提示
	 */
	r.POST("/ProxyBaiduWebRest/loadWd", api.LoadWd)
	/*
	 *auth-service
	 */
	userApi := r.Group("/userWebRest")
	{
		userApi.POST("/currentInfo", api.CurrentInfo)
		userApi.POST("/login", api.Login)
		userApi.GET("/listAllRole", api.ListAllRole)
		userApi.POST("/updateRoleById", api.UpdateRoleById)
		userApi.POST("/updateUserById", api.UpdateUserById)
		userApi.POST("/updatePasswdById", api.UpdatePasswd)
	}
	apiv1 := r.Group("/api/v1")
	apiv1.Use(jwt.JWT())
	{
	}

	return r
}
