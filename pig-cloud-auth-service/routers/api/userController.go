package api

import (
	"fmt"
	"net/http"
	"time"

	"github.com/gaozhen1996/pig-cloud/models"
	"github.com/gaozhen1996/pig-cloud/pkg/e"
	"github.com/gaozhen1996/pig-cloud/pkg/util"
	"github.com/gin-gonic/gin"
)

type UserReqBo struct {
	Id       int
	Username string
	Password string
}

type UserBo struct {
	Account string `json:"account"`
	Name    string `json:"name"`
	Sex     int    `json:"sex"`
	Id      int    `json:"id"`
	Role    string `json:"role"`
	Logo    string `json:"logo"`
	Token   string `json:"token"`
	Menu    string `json:"menu"`
}

func Login(c *gin.Context) {
	request := UserReqBo{}
	response := UserBo{}
	code := 0
	c.BindJSON(&request)
	user := models.GetUser(models.User{Account: request.Username, Password: request.Password})
	if user.UserId > 0 {
		//更新登录时间
		user.LastLoginDate = time.Now()
		models.EditUser(user.UserId, user)
		//构造返回对象
		token, _ := util.GenerateToken(request.Username, request.Password)
		response = UserBo{
			Account: user.Account,
			Name:    user.Name,
			Sex:     user.Sex,
			Id:      int(user.UserId),
			Role:    user.Role.RoleDetail,
			Logo:    user.Photo,
			Token:   token,
			Menu:    user.Role.Menu,
		}
		code = e.SUCCESS
	} else {
		code = e.ERROR_ACCPASS
	}
	c.JSON(http.StatusOK, gin.H{
		"code": code,
		"msg":  e.GetMsg(code),
		"data": response,
	})
}

func UpdateUserById(c *gin.Context) {
	request := UserBo{}
	code := 0
	c.BindJSON(&request)
	success := models.EditUser(int64(request.Id), models.User{
		Sex:  request.Sex,
		Name: request.Name,
	})
	if success {
		code = e.SUCCESS
	} else {
		code = e.ERROR
	}
	c.JSON(http.StatusOK, gin.H{
		"code": code,
		"msg":  e.GetMsg(code),
		"data": nil,
	})
}

func UpdatePasswd(c *gin.Context) {
	request := UserReqBo{}
	code := 0
	c.BindJSON(&request)
	fmt.Println(request)
	success := models.EditUser(int64(request.Id), models.User{
		Password: request.Password,
	})
	if success {
		code = e.SUCCESS
	} else {
		code = e.ERROR
	}
	c.JSON(http.StatusOK, gin.H{
		"code": code,
		"msg":  e.GetMsg(code),
		"data": nil,
	})
}
