package com.gz.pigvideo.domain;
public class UserActivity implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;//主键id
    private Long uid;//用户id
    private Long createTime;//活跃时间
    private String name;//姓名
    private String account;//账号
    public UserActivity() {
        super();
    }
    public UserActivity(Long id,Long uid,Long createTime,String name,String account) {
        super();
        this.id = id;
        this.uid = uid;
        this.createTime = createTime;
        this.name = name;
        this.account = account;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return this.uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
