package com.gradutation.design.ljx.domain.mapper;

import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreDetailShipOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hehe on 18-3-28.
 */
@Mapper
public interface DiyStoreDetailShipOrderMapper extends DiyStoreBaseMapper<DiyStoreDetailShipOrderDTO,DiyStoreDetailShipOrderDO>{
 DiyStoreDetailShipOrderMapper INSTANCE = Mappers.getMapper(DiyStoreDetailShipOrderMapper.class);
}
