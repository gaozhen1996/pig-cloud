package models

import (
	"strings"
)

type Role struct {
	RoleId        int64    `gorm:"primary_key" json:"roleId"`           //角色id
	RoleDetail    string   `json:"roleDetail" gorm:"column:roleDetail"` //角色详情
	RoleName      string   `json:"roleName" gorm:"column:roleName"`     //角色名
	Permission    string   `gorm:"cloumn:permission"`                   //存在数据数据库的权限，字符类型
	PermissionArr []string `json:"permission" gorm:"-"`                 //不存数据库的权限，数组格式
	Content       string   `json:"content"`                             //用户活动内容
	DelFlag       int      `json:"delFlag"`                             //存在标识
	Menu          string   `json:"menu"`                                //菜单
}

func GetRole(roleId int64) (role Role) {
	db.Where("role_id = ?", roleId).First(&role)
	return
}

func ListRole(para Role) (roles []Role) {
	db.Where(para).Find(&roles)
	for i, role := range roles {
		permission := strings.TrimRight(role.Permission, ",")
		roles[i].PermissionArr = strings.Split(permission, ",")
	}
	return
}

func UpdateRoleById(id int, data interface{}) bool {
	db.Model(&Role{}).Where("role_id = ?", id).Updates(data)
	return true
}
