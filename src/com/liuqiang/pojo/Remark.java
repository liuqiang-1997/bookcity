package com.liuqiang.pojo;

import java.util.Date;

public class Remark {
    private Integer id;  //书评id号
    private Integer bookId;  // 被评图书id
    private String remark;  // 评论内容
    private Integer observer;  // 评论者id
    private Date remarkTime;  // 评论时间

    public Remark() {
    }

    public Remark(Integer id, Integer bookId, String remark, Integer observer, Date remarkTime) {
        this.id = id;
        this.bookId = bookId;
        this.remark = remark;
        this.observer = observer;
        this.remarkTime = remarkTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getObserver() {
        return observer;
    }

    public void setObserver(Integer observer) {
        this.observer = observer;
    }

    public Date getRemarkTime() {
        return remarkTime;
    }

    public void setRemarkTime(Date remarkTime) {
        this.remarkTime = remarkTime;
    }

    @Override
    public String toString() {
        return "Remark{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", remark='" + remark + '\'' +
                ", observer=" + observer +
                ", remarkTime=" + remarkTime +
                '}';
    }
}
