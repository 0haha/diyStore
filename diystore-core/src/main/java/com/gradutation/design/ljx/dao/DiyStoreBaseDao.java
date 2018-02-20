package com.gradutation.design.ljx.dao;

import java.util.List;

/**
 * Created by hehe on 18-2-5.
 */
public interface DiyStoreBaseDao<D,Q> {

    long insert(D d);

    int update(D d);

    int delete(long id);

    D queryById(long id);

    List<D> queryByPage(Q q);

    int updateByQuery(Q q);

    int count();

}
