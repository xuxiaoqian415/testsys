package se.zust.xxq160.servlet;

import se.zust.xxq160.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "subjective",urlPatterns = "/subjective")
public class SubjectiveServlet extends HttpServlet {
    TestService testService;
    @Override
    public void init() throws ServletException {
        testService = (TestService) getServletContext().getAttribute("testService");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int stuid = Integer.parseInt(request.getParameter("stuid"));
        int testid = Integer.parseInt(request.getParameter("testid"));
        session.setAttribute("stuid", stuid);
        session.setAttribute("testid", testid);
        List<Map<String,Object>> answers = testService.getSubAnswer(stuid, testid);
        request.setAttribute("answers", answers);
        request.getRequestDispatcher("WEB-INF/subjective.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer stuid = (Integer) session.getAttribute("stuid");
        Integer testid = (Integer) session.getAttribute("testid");
        String info = " ";
        String tn[]={"1","2"};
        float subjGrade = 0;
        for (int i=0; i<tn.length; i++) {
            String grade = request.getParameter(tn[i]);
            if(grade != null && grade != "")
                subjGrade += Float.parseFloat(grade);
        }
        info = testService.addGrade(testid, stuid, subjGrade);
        float sumall = testService.getSumall(testid, stuid);
        info += "该学生总成绩是：" + sumall;
        request.setAttribute("info", info);
        doGet(request, response);
    }
}
