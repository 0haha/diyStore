/**
 * Created by hehe on 18-3-6.
 */

import com.graduation.design.ljx.handler.impl.CancelShipHandler;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
public class HelloServlet extends HttpServlet {


    private String message;

    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World";
        System.out.println(message);

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
//        WebApplicationContext wc = ContextLoader.getCurrentWebApplicationContext();
//        UseCase uc = (UseCase)wc.getBean("useCase");
//        CancelShipHandler cs = uc.getCancelShipHandler();
//        cs.execute();
//        uc.getDiyStoreMainShipOrderQueryResut();
//        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy()
    {
        // 什么也不做
    }
}