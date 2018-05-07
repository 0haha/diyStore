package com.graduation.design.ljx.service;

import com.graduation.design.ljx.domain.dto.DiyStoreItemDTO;
import com.graduation.design.ljx.domain.processorResult.DiyStorePageQueryResult;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;

import java.util.List;

/**
 * Created by hehe on 18-4-3.
 */
public interface DiyStoreItemDaoService {
    /**
     * Get the whole page including the item by  pageInx and pageSize
     * @param pageIndex
     * @param pageSize
     * @return
     */
    DiyStoreProcessorResult<DiyStorePageQueryResult<DiyStoreItemDTO>> getPageOfDiyStoreItemDTOList(Integer pageIndex,Integer pageSize);

    /**
     * Get the Item Info by ItemId
     * @param itemId
     * @return
     */
    DiyStoreProcessorResult<List<DiyStoreItemDTO>> getDiyStoreItemDTOByItemId(Long itemId);

    /**
     *
     * @param words
     * @return
     */
    DiyStoreProcessorResult<DiyStorePageQueryResult<DiyStoreItemDTO>> queryPageOfDiyStoreItemListByKeyWords(String words,Integer pageIndex,Integer pageSize);
}
