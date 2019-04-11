package com.gz.pigvideo.domain;

import java.util.Date;

public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String password;//用户密码
    private Long roleId;//角色id
    private Integer sex;//性别-0:男，1:女
    private String name;//姓名
    private String photo;//头像，不超过65KB
    private java.util.Date createDate;//创建时间
    private java.util.Date lastLoginDate;//上一次登录时间
    private Integer delFlag;
    private String account;//用户账号
    private Role role;
    
	public User() {
		super();
	}

	public User(Long userId, String password, Long roleId, Integer sex, String name, String photo, Date createDate,
			Date lastLoginDate, Integer delFlag, String account, Role role) {
		super();
		this.userId = userId;
		this.password = password;
		this.roleId = roleId;
		this.sex = sex;
		this.name = name;
		this.photo = photo;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
		this.delFlag = delFlag;
		this.account = account;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(java.util.Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", roleId=" + roleId + ", sex=" + sex + ", name="
				+ name + ", photo=" + photo + ", createDate=" + createDate + ", lastLoginDate=" + lastLoginDate
				+ ", delFlag=" + delFlag + ", account=" + account + ", role=" + role + "]";
	}
    
}
