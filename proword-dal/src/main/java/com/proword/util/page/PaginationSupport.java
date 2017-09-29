package com.proword.util.page;

import java.util.List;

/**
 * 分页对象工具类
 * @author houkai
 */
public class PaginationSupport<T> {
    private List<T> list ;

    private int start;
    private int totalCount;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public PaginationSupport(List<T> list, int totalCount, int start) {
        this.totalCount = totalCount;
        this.start = start;
        this.list = list;
    }

    public PaginationSupport() {
    }


}
