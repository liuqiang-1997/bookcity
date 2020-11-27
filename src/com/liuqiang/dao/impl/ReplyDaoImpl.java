package com.liuqiang.dao.impl;

import com.liuqiang.dao.ReplyDao;
import com.liuqiang.pojo.Reply;

import java.util.List;

public class ReplyDaoImpl extends BaseDao implements ReplyDao {
    @Override
    public int addReply(Reply reply) {
        String sql = "insert into t_reply(remark_id,reply,reply_user,remark_user,reply_time) values(?,?,?,?,?)";
        return update(sql,reply.getRemarkId(),reply.getReply(),reply.getReplyUser(),reply.getRemarkUser(),
                reply.getReplyTime());
    }

    @Override
    public int deleteReply(Integer replyUser,Integer remarkId) {
        String sql = "delete from t_reply where reply_user = ? and remark_id = ?";
        return update(sql,replyUser,remarkId);
    }

    @Override
    public int clearReply() {
        String sql = " delete from t_reply where remark_id is null";
        return update(sql);
    }

    @Override
    public List<Reply> queryReplyByRemarkId(Integer remarkId) {
        String sql = "select id,remark_id as remarkId,reply,reply_user as replyUser,remark_user as remarkUser," +
                "reply_time as replyTime from t_reply where remark_id = ? order by reply_time desc";
        return queryForList(Reply.class,sql,remarkId);
    }

    @Override
    public List<Reply> queryReplyByreplyUser(Integer replyUser) {
        String sql = "select id,remark_id as remarkId,reply,reply_user as replyUser,remark_user as remarkUser," +
                "reply_time as replyTime from t_reply where reply_user = ? order by reply_time desc";
        return queryForList(Reply.class,sql,replyUser);
    }

    @Override
    public List<Reply> queryReplyByremarkUser(Integer remarkUser) {
        String sql = "select id,remark_id as remarkId,reply,reply_user as replyUser,remark_user as remarkUser," +
                "reply_time as replyTime from t_reply where remark_user = ? order by reply_time desc";
        return queryForList(Reply.class,sql,remarkUser);
    }
}
