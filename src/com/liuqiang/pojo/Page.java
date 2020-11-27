package com.liuqiang.pojo;

import java.util.List;

/**
 * page是分页的模型对象
 * @param <T> 具体的bean对象
 */
public class Page<T> {

    public static final int PAGE_SIZE = 4;  // 每页个数
    private Integer pageNo;  // 当前页码
    private Integer pageTotal;  // 总页码
    private Integer pageSize = PAGE_SIZE;   //当前页显示数量
    private Integer pageTotalCount;  //总记录数
    private List<T> items;  //当前页数据
    private String url;  //分页条的请求地址

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = (List<T>) items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //设置数据边界的有效检测
        if(pageNo<1){
            pageNo = 1;
        }
        if(pageNo>pageTotal){
            pageNo = pageTotal;
        }

        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return (List<T>) items;
    }

    public void setItems(List<T> items) {
        this.items = (List<T>) items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
