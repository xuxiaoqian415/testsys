package se.zust.xxq160.listener;

import se.zust.xxq160.service.ClassesService;
import se.zust.xxq160.service.TestService;
import se.zust.xxq160.service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServiceListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserService userService = new UserService();
        servletContextEvent.getServletContext().setAttribute("userService", userService);
        System.out.println("userService对象创建成功");
        ClassesService classesService = new ClassesService();
        servletContextEvent.getServletContext().setAttribute("classesService", classesService);
        System.out.println("classesService对象创建成功");
        TestService testService = new TestService();
        servletContextEvent.getServletContext().setAttribute("testService", testService);
        System.out.println("testService对象创建成功");
    }
}
