package util

import "time"

func DateToTimestamp(date string) int64 {
	//日期转化为时间戳
	timeLayout := "2006-01-02"           //转化所需模板
	loc, _ := time.LoadLocation("Local") //获取时区
	tmp, _ := time.ParseInLocation(timeLayout, date, loc)
	timestamp := tmp.Unix() //转化为时间戳 类型是int64
	return timestamp
}
