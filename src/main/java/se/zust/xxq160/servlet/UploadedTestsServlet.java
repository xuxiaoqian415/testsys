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

@WebServlet(name = "uploadedTests",urlPatterns = "/uploadedTests")
public class UploadedTestsServlet extends HttpServlet {
    TestService testService;
    @Override
    public void init() throws ServletException {
        testService = (TestService) getServletContext().getAttribute("testService");
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Integer t_id = ((User) session.getAttribute("thisUser")).getId();
        List<Test> tests = testService.searchTests_t(t_id);
        request.setAttribute("tests", tests);
        for (Test t: tests) {
            int tid = t.getId();
            String classesId = testService.getClassesId(tid);
            int suball = testService.getSuball(classesId);
            testService.setSuball(tid, suball);
        }
        request.getRequestDispatcher("WEB-INF/uploadedTests.jsp").forward(request,response);
    }
}
