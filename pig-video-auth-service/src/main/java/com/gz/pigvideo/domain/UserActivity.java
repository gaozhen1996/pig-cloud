package com.gz.pigvideo.domain;
public class UserActivity implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;//主键id
    private Integer uid;//用户id
    private Long createTime;//活跃时间
    private String name;//姓名
    private String behavior;//用户活动行为
    private String account;//账号
    private String content;//用户活动内容
    public UserActivity() {
        super();
    }
    public UserActivity(Integer id,Integer uid,Long createTime,String name,String behavior,String account,String content) {
        super();
        this.id = id;
        this.uid = uid;
        this.createTime = createTime;
        this.name = name;
        this.behavior = behavior;
        this.account = account;
        this.content = content;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
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

    public String getBehavior() {
        return this.behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
