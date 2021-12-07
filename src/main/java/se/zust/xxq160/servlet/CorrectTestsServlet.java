package se.zust.xxq160.servlet;

import se.zust.xxq160.model.Answer;
import se.zust.xxq160.model.Test;
import se.zust.xxq160.model.User;
import se.zust.xxq160.service.TestService;
import se.zust.xxq160.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "correctTests",urlPatterns = "/correctTests")
public class CorrectTestsServlet extends HttpServlet {
    TestService testService;
    UserService userService;
    @Override
    public void init() throws ServletException {
        testService = (TestService) getServletContext().getAttribute("testService");
        userService = (UserService) getServletContext().getAttribute("userService");
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Integer t_id = ((User) session.getAttribute("thisUser")).getId();
        List<Test> tests = testService.searchTests_t(t_id);
        List<Answer> answers = new ArrayList<>();
        for(Test t: tests) {
            int testId = t.getId();
            List<Answer> answers2 = testService.searchAnswers_t(testId);
            for(Answer a: answers2) {
                a.setStuname(userService.searchNameById(a.getStuid()));
                a.setObjAllScore(testService.getAllScore(0, a.getTestid()));
                a.setSubjAllScore(testService.getAllScore(2, a.getTestid()));
                answers.add(a);
            }
        }
        request.setAttribute("answers", answers);
        request.getRequestDispatcher("WEB-INF/correctTests.jsp").forward(request,response);
    }
}
