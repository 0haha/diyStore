package com.graduation.design.ljx.service;

import com.graduation.design.ljx.domain.dto.DiyStoreBaseDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreUserDTO;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;

import java.util.List;

/**
 * Created by hehe on 18-4-5.
 */
public interface DiyStoreUserDaoService {

    DiyStoreProcessorResult<Void> persistUser(DiyStoreUserDTO diyStoreUserDTO,boolean bNewUO);

    DiyStoreProcessorResult<List<DiyStoreUserDTO>> queryByUserId(Long userId);

    DiyStoreProcessorResult<List<DiyStoreUserDTO>> queryByBuyerName(String userName);

    DiyStoreProcessorResult<List<DiyStoreUserDTO>> queryBySellerName(String sellerName);
}
