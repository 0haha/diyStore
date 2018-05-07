package com.graduation.design.ljx.domain.processorResult;

import java.util.List;

/**
 * Created by hehe on 18-3-28.
 */
public class DiyStorePageQueryResult<T> extends DiyStoreProcessorResult<List<T>> {

    private static final long serialVersionUID = 7977613232523202662L;

    private int pageIndex;

    private int totalCount;

    private int pageSize;

    public DiyStorePageQueryResult(){}

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
