package com.liuqiang.pojo;

import java.util.Date;

public class Reply {

    private Integer id;
    private Integer remarkId;
    private String reply;
    private Integer replyUser;
    private Integer remarkUser;
    private Date replyTime;

    public Reply() {
    }

    public Reply(Integer id, Integer remarkId, String reply, Integer replyUser, Integer remarkUser, Date replyTime) {
        this.id = id;
        this.remarkId = remarkId;
        this.reply = reply;
        this.replyUser = replyUser;
        this.remarkUser = remarkUser;
        this.replyTime = replyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Integer getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(Integer replyUser) {
        this.replyUser = replyUser;
    }

    public Integer getRemarkUser() {
        return remarkUser;
    }

    public void setRemarkUser(Integer remarkUser) {
        this.remarkUser = remarkUser;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", remarkId=" + remarkId +
                ", reply='" + reply + '\'' +
                ", replyUser=" + replyUser +
                ", remarkUser=" + remarkUser +
                ", replyTime=" + replyTime +
                '}';
    }
}
