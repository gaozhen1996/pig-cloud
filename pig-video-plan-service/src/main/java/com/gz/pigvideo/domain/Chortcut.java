package com.gz.pigvideo.domain;
public class Chortcut implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;//自增长id
    private Integer uid;//每一个快捷方式都关联一个User，当值为0时，表示公共数据
    private String imgUrl;//快捷方式图标的路径
    private String name;//快捷方式名称
    private Integer index;//顺序
    private java.util.Date addDate;//添加时间
    private String url;//快捷方式指向的地址
    private Integer relation;//当值为0表示是用户自己添加的，否则关联的是公共快捷方式
    public Chortcut() {
        super();
    }
    public Chortcut(Integer id,Integer uid,String imgUrl,String name,Integer index,java.util.Date addDate,String url,Integer relation) {
        super();
        this.id = id;
        this.uid = uid;
        this.imgUrl = imgUrl;
        this.name = name;
        this.index = index;
        this.addDate = addDate;
        this.url = url;
        this.relation = relation;
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

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public Integer getRelation() {
        return this.relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

}
