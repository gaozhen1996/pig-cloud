package com.gz.pigvideo.domain;
public class Role implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long roleId;//角色id
    private String roleDetail;//角色详情
    private String roleName;//角色名
    private Integer delFlag;//存在标识
    public Role() {
        super();
    }
    public Role(Long roleId,String roleDetail,String roleName,Integer delFlag) {
        super();
        this.roleId = roleId;
        this.roleDetail = roleDetail;
        this.roleName = roleName;
        this.delFlag = delFlag;
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

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

}
