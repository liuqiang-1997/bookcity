package com.liuqiang.service;

import com.liuqiang.pojo.Reply;

import java.util.List;

public interface ReplyService {
    /**
     * 新增回复
     * @param reply
     */
    public void addReply(Reply reply);

    /**
     * 个人删除回复
     * @param replyUser
     * @param remarkId
     */
    public void deleteReply(Integer replyUser,Integer remarkId);

    /**
     * 清空已删评论下的回复
     */
    public void clearReply();

    /**
     * 展示评论下的所有回复
     * @param remarkId
     * @return
     */
    public List<Reply> queryReplyByRemarkId(Integer remarkId);

    /**
     * 个人查看自己的回复
     * @param replyUser
     * @return
     */
    public List<Reply> queryReplyByreplyUser(Integer replyUser);

    /**
     * 个人查看自己被回复的内容
     * @param remarkUser
     * @return
     */
    public List<Reply> queryReplyByremarkUser(Integer remarkUser);
}
