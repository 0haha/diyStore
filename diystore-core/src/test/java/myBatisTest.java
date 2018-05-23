import com.graduation.design.ljx.domain.dto.DiyStoreItemDTO;
import com.graduation.design.ljx.domain.processorResult.DiyStorePageQueryResult;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.service.DiyStoreItemDaoService;
import com.gradutation.design.ljx.dao.DiyStoreItemDao;
import com.gradutation.design.ljx.dao.DiyStoreMainShipOrderDao;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreItemDO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;
import com.gradutation.design.ljx.domain.query.DiyStoreItemQuery;
import com.gradutation.design.ljx.domain.query.DiyStoreMainShipOrderQuery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by hehe on 18-2-5.
 */
public class myBatisTest {

    public static void main(String[] args)throws Exception{
        String resource = "mybatis/mybatis-conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        List<DiyStoreMainShipOrderDO> d1 = sqlSession.selectList("com.gradutation.design.ljx.dao.DiyStoreMainShipOrderDao.queryById",1L);
//        System.out.println(d1);
//        List<DiyStoreMainShipOrderDO> l = sqlSession.selectList("com.gradutation.design.ljx.dao.DiyStoreMainShipOrderDao.query");
//        System.out.println(l);

        DiyStoreMainShipOrderDO dd = new DiyStoreMainShipOrderDO();
        dd.setId(2L);
        dd.setRowVersion(0);
        dd.setBuyerId(11L);
        dd.setBuyerNick("tata");
        dd.setCity("Beijing");

   //     sqlSession.insert("com.gradutation.design.ljx.dao.DiyStoreMainShipOrderDao.insert",dd);
   //     sqlSession.commit();

        DiyStoreItemDao dao = sqlSession.getMapper(DiyStoreItemDao.class);
        DiyStoreItemQuery q = new DiyStoreItemQuery();
        q.setPageSize(6);
        q.setPageIndex(1);
        List<DiyStoreItemDO> dodo = dao.queryByPage(q);
        System.out.println("mainShipOrder:"+dodo);
//        DiyStoreMainShipOrderQuery query = new DiyStoreMainShipOrderQuery();
//        query.setBuyerId(100L);
//        List<DiyStoreMainShipOrderDO> ddd = dao.queryByPage(query);


          //dao.update(dd);
          //sqlSession.commit();
          sqlSession.close();
          //Note: if you want to change the data record such as insert,update or delete you should commit in the end!
    }
}
