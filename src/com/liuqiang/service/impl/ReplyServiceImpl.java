package com.liuqiang.service.impl;

import com.liuqiang.dao.ReplyDao;
import com.liuqiang.dao.impl.ReplyDaoImpl;
import com.liuqiang.pojo.Reply;
import com.liuqiang.service.ReplyService;

import java.util.Date;
import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    ReplyDao replyDao = new ReplyDaoImpl();

    @Override
    public void addReply(Reply reply) {
        reply = new Reply(reply.getId(), reply.getRemarkId(),reply.getReply(),reply.getReplyUser(),reply.getRemarkUser(),new Date());
        replyDao.addReply(reply);
    }

    @Override
    public void deleteReply(Integer replyUser, Integer remarkId) {
        replyDao.deleteReply(replyUser,remarkId);

    }

    @Override
    public void clearReply() {
        replyDao.clearReply();
    }

    @Override
    public List<Reply> queryReplyByRemarkId(Integer remarkId) {
        return replyDao.queryReplyByRemarkId(remarkId);
    }

    @Override
    public List<Reply> queryReplyByreplyUser(Integer replyUser) {
        return replyDao.queryReplyByreplyUser(replyUser);
    }

    @Override
    public List<Reply> queryReplyByremarkUser(Integer remarkUser) {
        return replyDao.queryReplyByremarkUser(remarkUser);
    }
}
