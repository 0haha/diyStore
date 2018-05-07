package com.gradutation.design.ljx.domain.mapper;

/**
 * Created by hehe on 18-3-28.
 */
public interface DiyStoreBaseMapper<T,D> {

    T mapDO2DTO(D d);

    D mapDTO2DO(T t);
}
