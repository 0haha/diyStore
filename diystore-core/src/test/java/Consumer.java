import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hehe on 18-2-22.
 */
public class Consumer {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/consumer.xml");
        context.start();
        System.out.println( "Consumer start...");
//        DiyStoreMainShipOrderService diyStoreMainShipOrderService = context.getBean(DiyStoreMainShipOrderService.class);
//        System.out.println( diyStoreMainShipOrderService.sayHello("Nick"));


    }
}
