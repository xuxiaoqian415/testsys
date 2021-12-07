package se.zust.xxq160.servlet;

import se.zust.xxq160.model.Class;
import se.zust.xxq160.model.Test;
import se.zust.xxq160.model.User;
import se.zust.xxq160.service.ClassesService;
import se.zust.xxq160.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "testOnline",urlPatterns = "/testOnline")
public class TestOnlineServlet extends HttpServlet {
    ClassesService classesService;
    TestService testService;
    @Override
    public void init() throws ServletException {
        classesService = (ClassesService) getServletContext().getAttribute("classesService");
        testService = (TestService) getServletContext().getAttribute("testService");
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        User thisUser = (User) request.getSession(true).getAttribute("thisUser");
        Integer sid=thisUser.getId();
        List<Class> classes=classesService.searchClasses_s(sid);
        List<Test> alltest=new ArrayList<>();
        for (int i=0;i<classes.size();i++){
            int classid=classes.get(i).getId();
            List<Test> tests=testService.searchByclassid(String.valueOf(classid));
            for(Test t1:tests){
                int tid1 = t1.getId();
                Boolean flag = true;
                for(Test t2:alltest) {
                    int tid2 = t2.getId();
                    if(tid1 == tid2) {
                        flag = false;
                        break;
                    }
                }
                if(flag) alltest.add(t1);
            }
        }
        for (Test t: alltest) {
            int tid = t.getId();
            String classesId = testService.getClassesId(tid);
            int suball = testService.getSuball(classesId);
            testService.setSuball(tid, suball);
        }
        request.setAttribute("alltest",alltest);
        request.getRequestDispatcher("WEB-INF/testOnline.jsp").forward(request,response);
    }
}
