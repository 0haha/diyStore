import com.graduation.design.ljx.handler.impl.CancelShipHandler;
import com.gradutation.design.ljx.dao.DiyStoreMainShipOrderDao;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;

/**
 * Created by hehe on 18-3-6.
 */
public class UseCase {
//    private CancelShipHandler cancelShipHandler;

    private DiyStoreMainShipOrderDao diyStoreMainShipOrderDao;

//    public CancelShipHandler getCancelShipHandler() {
//        return cancelShipHandler;
//    }

    /*public void setCancelShipHandler(CancelShipHandler cancelShipHandler) {
        this.cancelShipHandler = cancelShipHandler;
    }*/

    public DiyStoreMainShipOrderDao getDiyStoreMainShipOrderDao() {
        return diyStoreMainShipOrderDao;
    }

    public void setDiyStoreMainShipOrderDao(DiyStoreMainShipOrderDao diyStoreMainShipOrderDao) {
        this.diyStoreMainShipOrderDao = diyStoreMainShipOrderDao;
    }

    public void getDiyStoreMainShipOrderQueryResut(){
        DiyStoreMainShipOrderDO diyStoreMainShipOrderDO = diyStoreMainShipOrderDao.queryById(1L);
        System.out.println("BuyerId is:"+diyStoreMainShipOrderDO.getBuyerId());
    }
}
