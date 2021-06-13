package com.gz.pigcloud.domain;
public class Readlater implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;//主键
    private Integer uid;//用户id
    private Integer parentId;//父节点id
    private Integer readStatus;//阅读状态
    private String title;//标题
    private java.util.Date addDate;//创建时间
    private String url;//链接URL
    public Readlater() {
        super();
    }
    public Readlater(Integer id,Integer uid,Integer parentId,Integer readStatus,String title,java.util.Date addDate,String url) {
        super();
        this.id = id;
        this.uid = uid;
        this.parentId = parentId;
        this.readStatus = readStatus;
        this.title = title;
        this.addDate = addDate;
        this.url = url;
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

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getReadStatus() {
        return this.readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.util.Date getAddDate() {
        return this.addDate;
    }

    public void setAddDate(java.util.Date addDate) {
        this.addDate = addDate;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
	@Override
	public String toString() {
		return "Readlater [id=" + id + ", uid=" + uid + ", parentId=" + parentId + ", readStatus=" + readStatus
				+ ", title=" + title + ", addDate=" + addDate + ", url=" + url + "]";
	}

}
