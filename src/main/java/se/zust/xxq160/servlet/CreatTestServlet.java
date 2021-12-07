package se.zust.xxq160.servlet;

import se.zust.xxq160.model.Test;
import se.zust.xxq160.model.User;
import se.zust.xxq160.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "creatTest",urlPatterns = "/creatTest")
public class CreatTestServlet extends HttpServlet {
    TestService testService;
    @Override
    public void init() throws ServletException {
        testService = (TestService) getServletContext().getAttribute("testService");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/creatTest.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String back = request.getParameter("back");
        String classesId = request.getParameter("classesId");
        String time = request.getParameter("time");
        String testName = request.getParameter("testName");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String teachName = request.getParameter("teachName");
        String info = " ";
        if(classesId == null || time == null || time == "" || testName == null || start == null || end == null || teachName == null) {
            info = "试卷信息均不能为空！";
            request.setAttribute("back", back);
            request.setAttribute("info", info);
        }
        else {
            HttpSession session = request.getSession(true);
            int t_id = ((User) session.getAttribute("thisUser")).getId();
            String t_name = ((User) session.getAttribute("thisUser")).getName();
            int suball = testService.getSuball(classesId);
            Test test = new Test(testName, start, end, Integer.parseInt(time), t_id, 0, t_name, classesId, 0, suball);
            test.setId();
            List<Test> tests = testService.searchTests_t(t_id);
            info = testService.addTest(tests, test);
            session.setAttribute("testId", test.getId());
            session.setAttribute("order", 0);
            request.setAttribute("back", back);
            request.setAttribute("info", info);
        }
        request.getRequestDispatcher("WEB-INF/info.jsp").forward(request,response);
    }
}
