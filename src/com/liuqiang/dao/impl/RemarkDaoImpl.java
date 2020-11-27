package com.liuqiang.dao.impl;

import com.liuqiang.dao.RemarkDao;
import com.liuqiang.pojo.Remark;

import java.util.List;

public class RemarkDaoImpl extends BaseDao implements RemarkDao {
    @Override
    public int addRemark(Remark remark) {
        String sql = "insert into t_remark(book_id,remark,observer,remark_time) values(?,?,?,?)";
        return update(sql,remark.getBookId(),remark.getRemark(),remark.getObserver(),remark.getRemarkTime());
    }

    @Override
    public List<Remark> queryRemarkByBookId(Integer bookId) {
        String sql = "select id,book_id as bookId,remark,observer,remark_time as remarkTime from t_remark where " +
                "book_id = ?";
        return queryForList(Remark.class,sql,bookId);
    }

    @Override
    public List<Remark> queryRemarkByObserver(Integer userId) {
        String sql = "select id,book_id as bookId,remark,observer,remark_time as remarkTime from t_remark where observer = ?";
        return queryForList(Remark.class,sql,userId);
    }

    @Override
    public int deleteRemark(Integer id) {
        String sql = "delete from t_remark where id = ?";
        return update(sql,id);
    }
}
