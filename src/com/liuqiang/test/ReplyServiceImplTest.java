package com.liuqiang.test;

import com.liuqiang.dao.ReplyDao;
import com.liuqiang.dao.impl.ReplyDaoImpl;
import com.liuqiang.pojo.Reply;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ReplyServiceImplTest {
    private ReplyDao  replyDao = new ReplyDaoImpl();
    @Test
    public void addReply() {
        replyDao.addReply( new Reply(null,35,"年轻不知软饭香，错把青春到插秧",10,9,new Date()));
        replyDao.addReply( new Reply(null,35,"确实不好搞",12,9,new Date()));
        replyDao.addReply( new Reply(null,35,"表示认同",17,9,new Date()));
        replyDao.addReply( new Reply(null,35,"推荐别的书吧",18,9,new Date()));
        replyDao.addReply( new Reply(null,35,"吃得苦中苦，才能开路虎",19,9,new Date()));
    }

    @Test
    public void deleteReply() {
        replyDao.deleteReply(19,35);
    }

    @Test
    public void clearReply() {
        replyDao.clearReply();
    }

    @Test
    public void queryReplyByRemarkId() {
    }

    @Test
    public void queryReplyByreplyUser() {
    }
}