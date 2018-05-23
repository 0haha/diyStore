package mybatis;

import com.gradutation.design.ljx.dao.*;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreDetailShipOrderDO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreItemDO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreUserDO;
import com.gradutation.design.ljx.domain.query.DiyStoreDetailShipOrderQuery;
import com.gradutation.design.ljx.domain.query.DiyStoreItemQuery;
import com.gradutation.design.ljx.domain.query.DiyStoreMainShipOrderQuery;
import com.gradutation.design.ljx.domain.query.DiyStoreUserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.xml.soap.Detail;
import java.io.IOException;
import java.util.List;

/**
 * Created by hehe on 18-3-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis/mybatis-spring.xml","classpath:spring/diystore-core-service.xml"})
public class DiyStoreDaoTest {

    @Resource
    private DiyStoreMainShipOrderDao diyStoreMainShipOrderDao;
    @Resource
    private DiyStoreDetailShipOrderDao diyStoreDetailShipOrderDao;
    @Resource
    private DiyStoreItemDao diyStoreItemDao;
    @Resource
    private DiyStoreAddressDao diyStoreAddressDao;

    @Resource
    private DiyStoreUserDao diyStoreUserDao;

    @Test
    public void mainShipInsertTest(){
        DiyStoreMainShipOrderDO diyStoreMainShipOrderDO = new DiyStoreMainShipOrderDO();
        diyStoreMainShipOrderDO.setBuyerId(1L);
        diyStoreMainShipOrderDO.setmainShipOrderId(2L);
        diyStoreMainShipOrderDao.insert(diyStoreMainShipOrderDO);
    }

    @Test
    public void detailShipInsertTest(){

        DiyStoreDetailShipOrderDO diyStoreDetailShipOrderDO = new DiyStoreDetailShipOrderDO();
        diyStoreDetailShipOrderDO.setBizType(1);
        diyStoreDetailShipOrderDO.setBuyerId(1L);
        diyStoreDetailShipOrderDO.setItemName("Nick建数据库的时候数据编码");
        diyStoreDetailShipOrderDO.setItemId(2L);
        diyStoreDetailShipOrderDO.setSellerId(3L);
        diyStoreDetailShipOrderDO.setDetailShipOrderId(4L);
        diyStoreDetailShipOrderDO.setMainShipOrderId(5L);
        diyStoreDetailShipOrderDO.setSellerId(6L);

        System.out.println("Insert record id is:"+diyStoreDetailShipOrderDao.insert(diyStoreDetailShipOrderDO));
    }

    @Test
    public void itemInsertTest(){
        DiyStoreItemDO diyStoreItemDO = new DiyStoreItemDO();
        diyStoreItemDO.setItemId(1L);
        diyStoreItemDO.setSellerId(2L);
        System.out.println(diyStoreItemDao.insert(diyStoreItemDO));
    }


    @Test
    public void MainShipOrderQueryAndUpdate(){
        DiyStoreMainShipOrderQuery diyStoreMainShipOrderQuery = new DiyStoreMainShipOrderQuery();
        diyStoreMainShipOrderQuery.setId(1L);
        //diyStoreMainShipOrderQuery.setBuyerId(1L);
        DiyStoreMainShipOrderDO diyStoreMainShipOrderDO1 = diyStoreMainShipOrderDao.queryById(1L);
        List<DiyStoreMainShipOrderDO> diyStoreMainShipOrderDO2 = diyStoreMainShipOrderDao.queryByPage(diyStoreMainShipOrderQuery);
        List<DiyStoreMainShipOrderDO> diyStoreMainShipOrderDO3 = diyStoreMainShipOrderDao.query();

        System.out.println(diyStoreMainShipOrderDO1);
//        System.out.println(diyStoreMainShipOrderDO2.get(1).getBuyerId());

        diyStoreMainShipOrderDO1.setmainShipOrderId(121L);
        diyStoreMainShipOrderDao.update(diyStoreMainShipOrderDO1);
    }

    @Test
    public void DetailShipOrderQueryAndUpdate(){
        DiyStoreDetailShipOrderQuery diyStoreDetailShipOrderQuery = new DiyStoreDetailShipOrderQuery();
        diyStoreDetailShipOrderQuery.setdetailShipOrderId(4L);
        List<DiyStoreDetailShipOrderDO> diyStoreDetailShipOrderDO = diyStoreDetailShipOrderDao.queryByPage(diyStoreDetailShipOrderQuery);
        DiyStoreDetailShipOrderDO diyStoreDetailShipOrderDO1 = diyStoreDetailShipOrderDao.queryById(1L);

        diyStoreDetailShipOrderDO1.setItemName("Fool");
        diyStoreDetailShipOrderDao.update(diyStoreDetailShipOrderDO1);
    }

    @Test
    public void itemQueryAndUpdate(){
        DiyStoreItemQuery diyStoreItemQuery = new DiyStoreItemQuery();
        diyStoreItemQuery.setPageIndex(1);
        diyStoreItemQuery.setPageSize(6);
        DiyStoreItemDO diyStoreItemDO = diyStoreItemDao.queryById(5L);
        List<DiyStoreItemDO> diyStoreItemDOS = diyStoreItemDao.queryByPage(diyStoreItemQuery);
      //  diyStoreItemDO.setSellerId(121L);
      //  diyStoreItemDO.setBrandId(121L);
      //  diyStoreItemDao.update(diyStoreItemDO);
    }

    @Test
    public void startProvider(){
        try {
            System.out.println("Service start...");
            System.in.read();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void userQuery(){
        DiyStoreUserQuery diyStoreUserQuery = new DiyStoreUserQuery();
        diyStoreUserQuery.setBuyerNick("0haha");
        List<DiyStoreUserDO> l = diyStoreUserDao.queryByPage(diyStoreUserQuery);
    }


}
