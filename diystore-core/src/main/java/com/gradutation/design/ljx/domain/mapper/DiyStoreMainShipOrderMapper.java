package com.gradutation.design.ljx.domain.mapper;

import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hehe on 18-3-28.
 */
@Mapper
public interface DiyStoreMainShipOrderMapper extends DiyStoreBaseMapper<DiyStoreMainShipOrderDTO,DiyStoreMainShipOrderDO> {
   DiyStoreMainShipOrderMapper INSTANCE = Mappers.getMapper(DiyStoreMainShipOrderMapper.class);
}
