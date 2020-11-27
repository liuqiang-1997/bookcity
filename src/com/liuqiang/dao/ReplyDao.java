package com.liuqiang.dao;

import com.liuqiang.pojo.Reply;

import java.util.List;

public interface ReplyDao {
    /**
     * 新增回复
     * @param reply
     * @return
     */
    public int addReply(Reply reply);

    /**
     * 删除个人回复
     * @param replyUser 回复人
     * @param remarkId  被回复人
     * @return
     */
    public int deleteReply(Integer replyUser,Integer remarkId);

    /**
     * 清空已被删除的评论的回复
     * @return
     */
    public int clearReply();

    /**
     * 查看某条评论下的回复
     * @param remarkId 评论的id
     * @return
     */
    public List<Reply> queryReplyByRemarkId(Integer remarkId);

    /**
     * 查看个人的回复
     * @param replyUser
     * @return
     */
    public List<Reply> queryReplyByreplyUser(Integer replyUser);

    /**
     * 查看个人被回复的消息
     * @param remarkUser 回复表中的被回复的人
     * @return
     */
    public List<Reply> queryReplyByremarkUser(Integer remarkUser);
}
