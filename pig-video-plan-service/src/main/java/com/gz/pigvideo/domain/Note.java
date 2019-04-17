package com.gz.pigvideo.domain;
public class Note implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;//主键
    private Integer uid;//用户id
    private java.util.Date createTime;
    private java.util.Date updateTime;
    private String type;//类型
    private String title;//标题
    private Integer fromid;//所属目录的id
    private Object content;//内容
    public Note() {
        super();
    }
    public Note(Integer id,Integer uid,java.util.Date createTime,java.util.Date updateTime,String type,String title,Integer fromid,Object content) {
        super();
        this.id = id;
        this.uid = uid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
        this.title = title;
        this.fromid = fromid;
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

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFromid() {
        return this.fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
