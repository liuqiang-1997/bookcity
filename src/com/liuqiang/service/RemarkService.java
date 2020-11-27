package com.liuqiang.service;

import com.liuqiang.pojo.Remark;

import java.util.List;

public interface RemarkService {

    /**
     * 新增书评
     * @param remark
     */
    public void addRemark(Remark remark);

    /**
     * 通过图书id查看该图书下的所有书评
     * @param bookId
     * @return
     */
    public List<Remark> queryRemarkByBookId(Integer bookId);

    /**
     * 通过用户id查看该用户下的所有书评
     * @param userId
     * @return
     */
    public List<Remark> queryRemarkByObserver(Integer userId);

    /**
     * 通过评论id删除该条评论
     * @param id
     */
    public void deleteRemark(Integer id);
}
