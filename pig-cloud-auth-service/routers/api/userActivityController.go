package api

import (
	"net/http"
	"sort"
	"time"

	"github.com/gaozhen1996/pig-cloud/models"
	"github.com/gaozhen1996/pig-cloud/pkg/e"
	"github.com/gaozhen1996/pig-cloud/pkg/util"
	"github.com/gin-gonic/gin"
)

type UserActivityBO struct {
	Id      int
	Account string
}

func CurrentInfo(c *gin.Context) {
	request := UserActivityBO{}
	c.BindJSON(&request)
	userActivity := models.UserActivity{
		Uid:        request.Id,
		Account:    request.Account,
		CreateTime: time.Now().Unix(),
		Behavior:   "newTab",
	}
	models.InsertUserActivity(userActivity)
}

type NewTabCountBO struct {
	X                  []string             `json:"total_x"`
	Y                  []int                `json:"total_y"`
	NewTabDetailCounts []models.NewTabCount `json:"newTabDetailCounts"`
}

func ListNewTabCountByDate(c *gin.Context) {
	code := e.SUCCESS
	startDate := c.Query("startDate")
	endDate := c.Query("endDate")
	userActivities := models.ListNewTabCountByDate(util.DateToTimestamp(startDate), util.DateToTimestamp(endDate), "newTab")

	//定义返回x,y轴数据
	var x []string = make([]string, len(userActivities))
	var y []int = make([]int, len(userActivities))
	//中间变量，根据日期来分组
	var date_count = make(map[string]int)

	i := 0
	for _, newTabCount := range userActivities {
		count, ok := date_count[newTabCount.StrDate]
		if ok {
			//已经put搭配map中了，需要来相加
			count = count + newTabCount.Count
			date_count[newTabCount.StrDate] = count
		} else {
			//map中没有，放入x轴的数据中，并且对map进行初次赋值
			x[i] = newTabCount.StrDate
			i++
			date_count[newTabCount.StrDate] = newTabCount.Count
		}
	}
	//对x轴数据进行排序
	sort.Strings(x)
	//对y轴数据进行赋值
	for index, strDate := range x {
		y[index] = date_count[strDate]
	}
	response := NewTabCountBO{
		X:                  x,
		Y:                  y,
		NewTabDetailCounts: userActivities,
	}
	c.JSON(http.StatusOK, gin.H{
		"code": code,
		"msg":  e.GetMsg(code),
		"data": response,
	})
}
