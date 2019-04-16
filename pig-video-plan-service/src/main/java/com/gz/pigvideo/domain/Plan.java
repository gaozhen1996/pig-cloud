package com.gz.pigvideo.domain;
public class Plan implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;//主键
    private Integer uid;//用户id
    private Integer planType;//计划类型，分为四类
    private Long finishStatus;//完成状态，0未完成，1完成
    private java.util.Date finishDate;//完成时间
    private String planIndex;//位置
    private Long publicFlag;//公开标识
    private java.util.Date createDate;//创建时间
    private java.util.Date actualFinishDate;//实际完成时间
    private String content;//计划的内容
    public Plan() {
        super();
    }
    public Plan(Integer id,Integer uid,Integer planType,Long finishStatus,java.util.Date finishDate,String planIndex,Long publicFlag,java.util.Date createDate,java.util.Date actualFinishDate,String content) {
        super();
        this.id = id;
        this.uid = uid;
        this.planType = planType;
        this.finishStatus = finishStatus;
        this.finishDate = finishDate;
        this.planIndex = planIndex;
        this.publicFlag = publicFlag;
        this.createDate = createDate;
        this.actualFinishDate = actualFinishDate;
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

    public Integer getPlanType() {
        return this.planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Long getFinishStatus() {
        return this.finishStatus;
    }

    public void setFinishStatus(Long finishStatus) {
        this.finishStatus = finishStatus;
    }

    public java.util.Date getFinishDate() {
        return this.finishDate;
    }

    public void setFinishDate(java.util.Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getPlanIndex() {
        return this.planIndex;
    }

    public void setPlanIndex(String planIndex) {
        this.planIndex = planIndex;
    }

    public Long getPublicFlag() {
        return this.publicFlag;
    }

    public void setPublicFlag(Long publicFlag) {
        this.publicFlag = publicFlag;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getActualFinishDate() {
        return this.actualFinishDate;
    }

    public void setActualFinishDate(java.util.Date actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	@Override
	public String toString() {
		return "Plan [id=" + id + ", uid=" + uid + ", planType=" + planType + ", finishStatus=" + finishStatus
				+ ", finishDate=" + finishDate + ", planIndex=" + planIndex + ", publicFlag=" + publicFlag
				+ ", createDate=" + createDate + ", actualFinishDate=" + actualFinishDate + ", content=" + content
				+ "]";
	}
    
}
