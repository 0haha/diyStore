package com.graduation.design.ljx.service;

import com.graduation.design.ljx.domain.dto.DiyStoreAddressDTO;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;

import java.util.List;

/**
 * Created by hehe on 18-4-8.
 */
public interface DiyStoreAddressDaoService {
    DiyStoreProcessorResult<Void> persistAddress(DiyStoreAddressDTO diyStoreAddressDTO, boolean bNewAO);

    DiyStoreProcessorResult<List<DiyStoreAddressDTO>> queryByAddressId(Long addressId);

    DiyStoreProcessorResult<List<DiyStoreAddressDTO>> queryByUserId(Long userId);
}
