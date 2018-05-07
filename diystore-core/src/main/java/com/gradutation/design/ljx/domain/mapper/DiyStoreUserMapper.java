package com.gradutation.design.ljx.domain.mapper;

import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreUserDTO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hehe on 18-4-6.
 */
@Mapper
public interface DiyStoreUserMapper  extends DiyStoreBaseMapper<DiyStoreUserDTO,DiyStoreUserDO> {
    DiyStoreUserMapper INSTANCE = Mappers.getMapper(DiyStoreUserMapper.class);
}
