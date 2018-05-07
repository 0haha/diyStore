package com.gradutation.design.ljx.service.impl;

import com.graduation.design.ljx.domain.dto.DiyStoreItemDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStorePageQueryResult;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.service.DiyStoreItemDaoService;
import com.gradutation.design.ljx.dao.DiyStoreBaseDao;
import com.gradutation.design.ljx.dao.DiyStoreItemDao;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreItemDO;
import com.gradutation.design.ljx.domain.mapper.DiyStoreBaseMapper;
import com.gradutation.design.ljx.domain.mapper.DiyStoreItemMapper;
import com.gradutation.design.ljx.domain.query.DiyStoreItemQuery;
import com.gradutation.design.ljx.domain.query.PageQuery;
import com.gradutation.design.ljx.service.DiyStoreBaseDaoService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hehe on 18-4-3.
 */
@Slf4j
public class DiyStoreItemDaoServiceImpl extends DiyStoreBaseDaoServiceImpl<DiyStoreItemDTO,DiyStoreItemDO,DiyStoreItemQuery> implements DiyStoreItemDaoService{

    @Resource
    private DiyStoreItemDao diyStoreItemDao;



    @Override
    public DiyStoreItemDao getDao() {
        return diyStoreItemDao;
    }

    @Override
    public DiyStoreBaseMapper<DiyStoreItemDTO, DiyStoreItemDO> getMapper() {
        return DiyStoreItemMapper.INSTANCE;
    }

    @Override
    public DiyStoreProcessorResult<DiyStorePageQueryResult<DiyStoreItemDTO>> getPageOfDiyStoreItemDTOList(Integer pageIndex, Integer pageSize) {
        if(pageIndex==null || pageIndex.intValue()<0 || pageSize==null || pageSize.intValue()<=0){
            DiyStoreProcessorResult<DiyStorePageQueryResult<DiyStoreItemDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("Param error when call the getPageOfDiyStoreItemDTOList.pageIndex:"+pageIndex+",pageSize:"+pageSize);
        }
        DiyStoreItemQuery diyStoreItemQuery = new DiyStoreItemQuery();
        diyStoreItemQuery.setPageIndex(pageIndex);
        diyStoreItemQuery.setPageSize(pageSize);
        return this.queryByPage(diyStoreItemQuery);
    }

    @Override
    public DiyStoreProcessorResult<List<DiyStoreItemDTO>> getDiyStoreItemDTOByItemId(Long itemId) {
        if(isInValid(itemId)){
            DiyStoreProcessorResult<List<DiyStoreItemDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("Param error when call the getPageOfDiyStoreItemDTOList.ItemId:"+itemId);
        }
        DiyStoreItemQuery diyStoreItemQuery = new DiyStoreItemQuery();
        diyStoreItemQuery.setItemId(itemId);
        return this.queryForList(diyStoreItemQuery, PageQuery.MAX_PAGE_SIZE);
    }

    @Override
    public DiyStoreProcessorResult<DiyStorePageQueryResult<DiyStoreItemDTO>> queryPageOfDiyStoreItemListByKeyWords(String words,Integer pageIndex,Integer pageSize) {
        if(words == null || pageIndex==null || pageIndex.intValue() <0 || pageSize == null || pageSize.intValue() <=0){
            DiyStoreProcessorResult<List<DiyStoreItemDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("Param error when call the queryPageOfDiyStoreItemListByKeyWords.words:"+words+",pageIndex:"+pageIndex+",pageSize:"+pageSize);
        }
        DiyStoreItemQuery diyStoreItemQuery = new DiyStoreItemQuery();
        diyStoreItemQuery.setKeyWords(words);
        diyStoreItemQuery.setPageIndex(pageIndex);
        diyStoreItemQuery.setPageSize(pageSize);
        DiyStoreProcessorResult<DiyStorePageQueryResult<DiyStoreItemDTO>> diyStorePageQueryResultDiyStoreProcessorResult = new DiyStoreProcessorResult<>();
        DiyStorePageQueryResult<DiyStoreItemDTO> diyStorePageQueryResult = new DiyStorePageQueryResult<>();
        try {
            List<DiyStoreItemDO> DiyStoreItemDOList = this.getDao().queryByKeyWords(diyStoreItemQuery);
            List<DiyStoreItemDTO> diyStoreItemDTOList = new LinkedList<>();
            for (DiyStoreItemDO diyStoreItemDO : DiyStoreItemDOList) {
                DiyStoreItemDTO diyStoreItemDTO = this.getMapper().mapDO2DTO(diyStoreItemDO);
                diyStoreItemDTOList.add(diyStoreItemDTO);
            }
            diyStorePageQueryResult.setSuccess(true);
            diyStorePageQueryResult.setModel(diyStoreItemDTOList);
            diyStorePageQueryResultDiyStoreProcessorResult.setSuccess(true);
            diyStorePageQueryResultDiyStoreProcessorResult.setModel(diyStorePageQueryResult);
        }catch(Exception e){
            diyStorePageQueryResultDiyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
            log.error("DiyStore Query error:"+diyStoreItemQuery.toString());
        }
        return diyStorePageQueryResultDiyStoreProcessorResult;
    }
}
