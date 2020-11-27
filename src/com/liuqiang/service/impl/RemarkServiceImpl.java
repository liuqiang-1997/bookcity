package com.liuqiang.service.impl;

import com.liuqiang.dao.RemarkDao;
import com.liuqiang.dao.impl.RemarkDaoImpl;
import com.liuqiang.pojo.Order;
import com.liuqiang.pojo.Remark;
import com.liuqiang.service.RemarkService;
import com.liuqiang.utils.WebUtils;

import java.util.Date;
import java.util.List;

public class RemarkServiceImpl implements RemarkService {

    RemarkDao remarkDao = new RemarkDaoImpl();
    @Override
    public void addRemark(Remark remark) {
         remark = new Remark(remark.getId(),remark.getBookId(),remark.getRemark(),remark.getObserver(),new Date());
        remarkDao.addRemark(remark);
    }

    @Override
    public List<Remark> queryRemarkByBookId(Integer bookId) {
        return remarkDao.queryRemarkByBookId(bookId);
    }

    @Override
    public List<Remark> queryRemarkByObserver(Integer userId) {
        return remarkDao.queryRemarkByObserver(userId);
    }

    @Override
    public void deleteRemark(Integer id) {
         remarkDao.deleteRemark(id);
    }
}
