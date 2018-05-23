package com.gradutation.design.ljx.service.impl;

import com.graduation.design.ljx.domain.dto.DiyStoreBaseDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreItemDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStorePageQueryResult;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreBaseDO;
import com.gradutation.design.ljx.domain.mapper.DiyStoreBaseMapper;
import com.gradutation.design.ljx.domain.query.PageQuery;
import com.gradutation.design.ljx.service.DiyStoreBaseDaoService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hehe on 18-3-28.
 */
@Slf4j
public abstract class DiyStoreBaseDaoServiceImpl<T extends DiyStoreBaseDTO,D extends DiyStoreBaseDO,Q extends PageQuery> implements DiyStoreBaseDaoService<T,D,Q>{
   public DiyStoreBaseDaoServiceImpl(){}

   public DiyStoreProcessorResult<Long> insert(T t){
       DiyStoreProcessorResult<Long> diyStoreProcessorResult = new DiyStoreProcessorResult<Long>();
       diyStoreProcessorResult.setSuccess(true);
       try{
           t.setRowVersion(0);
           long num = this.getDao().insert(this.getMapper().mapDTO2DO(t));
           diyStoreProcessorResult.setModel(Long.valueOf(num));
       }catch(Throwable e){
            log.error("fail to insert "+t.toString());
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
       }
       return diyStoreProcessorResult;
   }

   public DiyStoreProcessorResult<Integer> update(T t){
       DiyStoreProcessorResult<Integer> diyStoreProcessorResult = new DiyStoreProcessorResult<Integer>();
       diyStoreProcessorResult.setSuccess(true);
       try{
           t.setRowVersion(0);
           int num = this.getDao().update(this.getMapper().mapDTO2DO(t));
           diyStoreProcessorResult.setModel(Integer.valueOf(num));
       }catch(Throwable e){
           log.error("fail to update "+t.toString());
           diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
       }
       return diyStoreProcessorResult;
   }

    @Override
    public DiyStoreProcessorResult<T> deleteByQuery(Q q) {
        DiyStoreProcessorResult<T> diyStoreProcessorResult = new DiyStoreProcessorResult<T>();
        diyStoreProcessorResult.setSuccess(true);
        try{
            D d = this.getDao().deleteByPage(q);
            T t = this.getMapper().mapDO2DTO(d);
            diyStoreProcessorResult.setModel(t);
        }catch(Throwable e){
            log.error("fail to query,q: "+q.toString());
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
        }
        return diyStoreProcessorResult;
    }

    public DiyStoreProcessorResult<Integer> delete(Long id){
       DiyStoreProcessorResult<Integer> diyStoreProcessorResult = new DiyStoreProcessorResult<Integer>();
       diyStoreProcessorResult.setSuccess(true);
       try{
           int num = this.getDao().delete(id);
           diyStoreProcessorResult.setModel(num);
       }catch(Throwable e){
           log.error("fail to delete,id: "+id);
           diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
       }
       return diyStoreProcessorResult;
   }

   public DiyStoreProcessorResult<T> queryById(Long id){
       DiyStoreProcessorResult<T> diyStoreProcessorResult = new DiyStoreProcessorResult<T>();
       diyStoreProcessorResult.setSuccess(true);
       try{
           T t = this.getMapper().mapDO2DTO(this.getDao().queryById(id));
           diyStoreProcessorResult.setModel(t);
       }catch (Throwable e){
          e.printStackTrace();
           log.error("fail to query,id: "+id+" The error message is:"+e.getMessage());
           diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
       }
       return diyStoreProcessorResult;
   }

   //todo: need to implment
   public DiyStoreProcessorResult<List<T>> query(){
       return null;
   }

   public DiyStoreProcessorResult<DiyStorePageQueryResult<T>> queryByPage(Q q){
       DiyStoreProcessorResult<DiyStorePageQueryResult<T>> diyStoreProcessorResult = new DiyStoreProcessorResult();
       diyStoreProcessorResult.setSuccess(true);
       DiyStorePageQueryResult<T> rst = new DiyStorePageQueryResult<T>();
       rst.setPageIndex(q.getPageIndex());
       rst.setPageSize(q.getPageSize());
       try{
         // int count = this.getDao().count(q);
         //  if(count == 0){
         //      return diyStoreProcessorResult;
         //  }
         //  rst.setTotalCount(count);
           List<D> dList = this.getDao().queryByPage(q);
           rst.succ(this.mapDO2DTO(dList));
           diyStoreProcessorResult.setModel(rst);
       }catch(Throwable e){
           log.error("fail to query,: "+q.toString());
           diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
       }
       return diyStoreProcessorResult;
   }

   public DiyStoreProcessorResult<Integer> count(Q q){
       DiyStoreProcessorResult<Integer> diyStoreProcessorResult = new DiyStoreProcessorResult<Integer>();
       diyStoreProcessorResult.setSuccess(true);
       try{
           int count = this.getDao().count(q);
           diyStoreProcessorResult.setModel(count);
       }catch(Throwable e){
           log.error("fail to query,: "+q.toString());
           diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
       }
       return diyStoreProcessorResult;
   }



    public List<T> mapDO2DTO(List<D> dList) {
        if(dList == null) {
            return null;
        } else {
            List<T> tList = new ArrayList(dList.size());
            Iterator var3 = dList.iterator();

            while(var3.hasNext()) {
                try {
                    D ret = (D) var3.next();
                    DiyStoreBaseMapper<T, D> m = this.getMapper();
                    tList.add(m.mapDO2DTO(ret));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            return tList;
        }
    }

    protected  boolean isInValid(Long param){return param == null||param.longValue()<=0L;}

    protected boolean isBizTypeValid(Integer biztype){return biztype == null || biztype.intValue()<=0;}

    protected  DiyStoreProcessorResult<List<T>> queryForList(Q q,int maxSize){
        DiyStoreProcessorResult<List<T>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
        diyStoreProcessorResult.setSuccess(true);
        if(maxSize>500){
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_QUERY_EXCEED_MAX_RANGE,false);
            log.error("The queryForList fail because maxSize exceed,query is:"+q.toString());
            return diyStoreProcessorResult;
        }
        try {
            q.setPageIndex(1);
            q.setPageSize(maxSize);
            List<D> dList = this.getDao().queryByPage(q);
            diyStoreProcessorResult.setModel(this.mapDO2DTO(dList));
        } catch (Exception var5) {
            log.error("fail to queryForList " +q.toString());
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
        }
        return diyStoreProcessorResult;
    }
}
