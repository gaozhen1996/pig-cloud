package jwt

import (
	"fmt"
	"net/http"
	"strings"
	"time"

	"github.com/gin-gonic/gin"

	"github.com/gaozhen1996/pig-cloud/models"
	"github.com/gaozhen1996/pig-cloud/pkg/e"
	"github.com/gaozhen1996/pig-cloud/pkg/util"
)

func JWT() gin.HandlerFunc {
	return func(c *gin.Context) {
		var code int
		var data interface{}

		code = e.SUCCESS
		token := c.Request.Header.Get("Authorization")

		if token == "" {
			code = e.INVALID_PARAMS
		} else {
			claims, err := util.ParseToken(token)
			if err != nil {
				code = e.ERROR_AUTH_CHECK_TOKEN_FAIL
			} else if time.Now().Unix() > claims.ExpiresAt {
				code = e.ERROR_AUTH_CHECK_TOKEN_TIMEOUT
			}
		}

		if code != e.SUCCESS {
			c.JSON(http.StatusUnauthorized, gin.H{
				"code": code,
				"msg":  e.GetMsg(code),
				"data": data,
			})

			c.Abort()
			return
		}

		c.Next()
	}
}

func IsPermitted(c *gin.Context, permission string) bool {
	code := e.ERROR_NOT_LOGIN
	havePer := false
	defer func() {
		if !havePer {
			c.JSON(http.StatusOK, gin.H{
				"code": code,
				"msg":  e.GetMsg(code),
				"data": nil,
			})
		}
	}()
	token := c.Request.Header.Get("Authorization")
	claims, err := util.ParseToken(token)
	if err != nil {
		return false
	}
	account := claims.Username
	user := models.GetUser(models.User{Account: account})
	fmt.Println(user.Role.Permission)
	fmt.Println(permission)
	havePer = strings.Contains(user.Role.Permission, permission)
	if !havePer {
		code = e.ERROR_NOT_PERMISSION
	} else {
		code = e.SUCCESS
	}
	return havePer
}
