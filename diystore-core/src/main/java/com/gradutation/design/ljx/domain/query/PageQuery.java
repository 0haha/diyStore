package com.gradutation.design.ljx.domain.query;

import java.io.Serializable;

/**
 * Created by hehe on 18-2-5.
 */
public class PageQuery implements Serializable{

    private static final long serialVersionUID = -8457284491812366994L;

    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int DEFAULT_PAGE_INDEX = 1;
    public static final int MAX_PAGE_SIZE = 500;
    private int pageIndex = 1;
    private int pageSize = 20;

    public PageQuery() {
    }

    public int getPageIndex() {
        return this.pageIndex <= 0?1:this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex <= 0?1:pageIndex;
    }

    public int getPageSize() {
        return this.pageSize > 0 && this.pageSize <= 500?this.pageSize:20;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0?20:pageSize;
    }

    public int getStartPos() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }

}
