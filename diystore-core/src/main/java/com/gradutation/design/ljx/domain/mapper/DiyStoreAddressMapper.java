package com.gradutation.design.ljx.domain.mapper;

import com.graduation.design.ljx.domain.dto.DiyStoreAddressDTO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreAddressDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hehe on 18-4-8.
 */
@Mapper
public interface DiyStoreAddressMapper extends DiyStoreBaseMapper<DiyStoreAddressDTO,DiyStoreAddressDO>{
    DiyStoreAddressMapper INSTANCE = Mappers.getMapper(DiyStoreAddressMapper.class);
}
