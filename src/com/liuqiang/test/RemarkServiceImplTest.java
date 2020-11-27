package com.liuqiang.test;

import com.liuqiang.dao.RemarkDao;
import com.liuqiang.dao.impl.RemarkDaoImpl;
import com.liuqiang.pojo.Remark;
import org.junit.Test;


import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class RemarkServiceImplTest {
    private RemarkDao remarkDao = new RemarkDaoImpl();

    @Test
    public void addRemark() {
        remarkDao.addRemark(new Remark(null,30,"我喜欢这本书",9,new Date()));
        remarkDao.addRemark(new Remark(null,40,"我喜欢这本书",9,new Date()));
        remarkDao.addRemark(new Remark(null,45,"我喜欢这本书",9,new Date()));
        remarkDao.addRemark(new Remark(null,28,"我喜欢这本书",9,new Date()));
        remarkDao.addRemark(new Remark(null,51,"我喜欢这本书",9,new Date()));

    }

    @Test
    public void queryRemarkByBookId() {
        List<Remark> remarks = remarkDao.queryRemarkByBookId(27);
        System.out.println(remarks);
    }

    @Test
    public void queryRemarkByObserver() {
        List<Remark> remarks = remarkDao.queryRemarkByObserver(9);
        System.out.println(remarks);
    }

    @Test
    public void deleteRemark() {
        remarkDao.deleteRemark(20);
    }
}