import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hehe on 18-2-22.
 */
public class Provider {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybatis/mybatis-spring.xml","spring/diystore-core-service.xml");
        System.out.println(context.getDisplayName()+":here");
        context.start();
        System.out.println("Service start...");
        System.in.read();
    }
}
