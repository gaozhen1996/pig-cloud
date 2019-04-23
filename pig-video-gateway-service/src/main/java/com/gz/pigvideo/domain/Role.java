package com.gz.pigvideo.domain;
public class Role implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long roleId;//角色id
    private String roleDetail;//角色详情
    private String roleName;//角色名
    private String permission;//权限
    private Integer delFlag;//存在标识
    private String menu;//菜单
    public Role() {
        super();
    }
    public Role(Long roleId,String roleDetail,String roleName,String permission,Integer delFlag,String menu) {
        super();
        this.roleId = roleId;
        this.roleDetail = roleDetail;
        this.roleName = roleName;
        this.permission = permission;
        this.delFlag = delFlag;
        this.menu = menu;
    }
    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleDetail() {
        return this.roleDetail;
    }

    public void setRoleDetail(String roleDetail) {
        this.roleDetail = roleDetail;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getMenu() {
        return this.menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}
