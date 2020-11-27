package com.liuqiang.dao;

import com.liuqiang.pojo.Remark;

import java.util.List;

public interface RemarkDao {
    /**
     * 新增书评
     * @param remark
     * @return
     */
    public int addRemark(Remark remark);

    /**
     * 通过图书id查找关于具体书的书评
     * @param bookId
     * @return
     */
    public List<Remark> queryRemarkByBookId(Integer bookId);

    /**
     * 通过评论者id查找评论者的所有书评
     * @param userId
     * @return
     */
    public List<Remark> queryRemarkByObserver(Integer userId);

    /**
     * 通过评论id删除评论
     * @param id
     * @return
     */
    public int deleteRemark(Integer id);

}
