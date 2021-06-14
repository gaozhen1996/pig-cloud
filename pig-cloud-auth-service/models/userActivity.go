package models

type UserActivity struct {
	Id         int    `gorm:"primary_key" json:"id"` //主键id
	Uid        int    `json:"uid"`                   //用户id
	CreateTime int64  `json:"createTime"`            //活跃时间
	Name       string `json:"name"`                  //姓名
	Behavior   string `json:"behavior"`              //用户活动行为
	Account    string `json:"account"`               //账号
	Content    string `json:"content"`               //用户活动内容
}

func InsertUserActivity(userActivity UserActivity) bool {
	db.Create(&userActivity)

	return true
}

type NewTabCount struct {
	Account string `json:"account"`
	StrDate string `json:"strDate" gorm:"column:strDate"`
	Count   int    `json:"count"`
}

func ListNewTabCountByDate(startDate, endDate int64, behavior string) []NewTabCount {
	sql := `
		select a.account,a.strDate,count(*) as count
		from  
		(SELECT t.account as account,
				FROM_UNIXTIME(t.create_time,'%Y-%m-%d ')  as strDate
		FROM user_activity t    
		where t.create_time >= ? and 
				t.create_time <= ?   and
				t.behavior = ?) a
		group by a.account,a.strDate;	
		`
	var newTabCount []NewTabCount
	db.Raw(sql, startDate, endDate, behavior).Scan(&newTabCount)
	return newTabCount
}
