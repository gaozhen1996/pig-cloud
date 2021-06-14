package api

import (
	"bytes"
	"net/http"

	"github.com/gaozhen1996/pig-cloud/middleware/jwt"
	"github.com/gaozhen1996/pig-cloud/models"
	"github.com/gaozhen1996/pig-cloud/pkg/e"
	"github.com/gin-gonic/gin"
)

type RoleReqBo struct {
	RoleId     int
	Menu       string
	Permission []string
}

func ListAllRole(c *gin.Context) {
	code := 200
	if !jwt.IsPermitted(c, "role:select") {
		return
	}
	roles := models.ListRole(models.Role{})
	response := roles
	c.JSON(http.StatusOK, gin.H{
		"code": code,
		"msg":  e.GetMsg(code),
		"data": response,
	})
}

func UpdateRoleById(c *gin.Context) {
	code := 200
	if !jwt.IsPermitted(c, "role:update") {
		return
	}
	request := RoleReqBo{}
	c.BindJSON(&request)
	var buffer bytes.Buffer
	for _, val := range request.Permission {
		buffer.WriteString(val + ",")
	}
	permission := buffer.String()
	result := models.UpdateRoleById(request.RoleId, models.Role{
		Menu:       request.Menu,
		Permission: permission,
	})
	if !result {
		code = e.ERROR
	}
	c.JSON(http.StatusOK, gin.H{
		"code": code,
		"msg":  e.GetMsg(code),
		"data": nil,
	})
}
