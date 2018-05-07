package com.gradutation.design.ljx.domain.mapper;

import com.graduation.design.ljx.domain.dto.DiyStoreItemDTO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreItemDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hehe on 18-4-3.
 */
@Mapper
public interface DiyStoreItemMapper extends DiyStoreBaseMapper<DiyStoreItemDTO,DiyStoreItemDO> {
    DiyStoreItemMapper INSTANCE = Mappers.getMapper(DiyStoreItemMapper.class);
}
