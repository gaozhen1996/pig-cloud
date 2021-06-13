package com.gz.pigcloud.domain;

public class VideoInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;//视频id
    private Long createTime;//视频创建时间戳
    private String videoURL;//视频链接地址
    private Integer delFlag;//删除标识
    private String content;//题目内容
    private Integer showFlag;//展示标识
    public VideoInfo() {
        super();
    }
    public VideoInfo(Long id,Long createTime,String videoURL,Integer delFlag,String content,Integer showFlag) {
        super();
        this.id = id;
        this.createTime = createTime;
        this.videoURL = videoURL;
        this.delFlag = delFlag;
        this.content = content;
        this.showFlag = showFlag;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getVideoURL() {
        return this.videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getShowFlag() {
        return this.showFlag;
    }

    public void setShowFlag(Integer showFlag) {
        this.showFlag = showFlag;
    }
	@Override
	public String toString() {
		return "VideoInfo [id=" + id + ", createTime=" + createTime + ", videoURL=" + videoURL + ", delFlag=" + delFlag
				+ ", content=" + content + ", showFlag=" + showFlag + "]";
	}
}
