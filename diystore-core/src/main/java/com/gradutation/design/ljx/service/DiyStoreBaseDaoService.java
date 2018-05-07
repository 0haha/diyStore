package com.gradutation.design.ljx.service;

import com.graduation.design.ljx.domain.processorResult.DiyStorePageQueryResult;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.gradutation.design.ljx.dao.DiyStoreBaseDao;
import com.gradutation.design.ljx.domain.mapper.DiyStoreBaseMapper;

import java.util.List;

/**
 * Created by hehe on 18-3-28.
 */
public interface DiyStoreBaseDaoService<T,D,Q> {
    DiyStoreBaseDao<D,Q> getDao();

    DiyStoreBaseMapper<T,D> getMapper();

    DiyStoreProcessorResult<Long> insert(T t);

    DiyStoreProcessorResult<Integer> update(T t);

    DiyStoreProcessorResult<Integer> delete(Long id);

    DiyStoreProcessorResult<T> queryById(Long id);

    DiyStoreProcessorResult<List<T>> query();

    DiyStoreProcessorResult<DiyStorePageQueryResult<T>> queryByPage(Q q);

    DiyStoreProcessorResult<Integer> count(Q q);

    DiyStoreProcessorResult<T> deleteByQuery(Q q);
}
