package models

import "time"

type User struct {
	UserId        int64     `gorm:"primary_key" json:"userId"` //用户密码
	Password      string    `json:"password"`                  //角色详情
	RoleId        int64     `gorm:"roleId" json:"roleId"`      //角色id
	Sex           int       `json:"sex"`                       //性别-0:男，1:女
	Name          string    `json:"name"`                      //姓名
	Photo         string    `json:"photo"`                     //头像，不超过65KB
	CreateDate    time.Time `json:"createDate"`                //创建时间
	LastLoginDate time.Time `json:"lastLoginDate"`             //上一次登录时间
	DelFlag       int       `json:"delFlag"`                   //存在标识
	Account       string    `json:"account"`                   //账号
	Role          Role      //角色
}

func GetUser(para User) (user User) {
	db.Where(para).First(&user)
	//db.Where(User{Account: account, Password: password}).First(&user)
	db.Model(&user).Related(&user.Role)

	return
}

func EditUser(id int64, data interface{}) bool {
	db.Model(&User{}).Where(" user_id = ?", id).Updates(data)

	return true
}
