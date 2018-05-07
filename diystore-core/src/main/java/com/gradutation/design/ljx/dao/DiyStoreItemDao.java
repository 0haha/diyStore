package com.gradutation.design.ljx.dao;

import com.gradutation.design.ljx.domain.dataobject.DiyStoreItemDO;
import com.gradutation.design.ljx.domain.query.DiyStoreItemQuery;

import java.util.List;

/**
 * Created by hehe on 18-3-22.
 */
public interface DiyStoreItemDao extends DiyStoreBaseDao<DiyStoreItemDO,DiyStoreItemQuery>{

    List<DiyStoreItemDO> queryByKeyWords(DiyStoreItemQuery diyStoreItemQuery);

}
