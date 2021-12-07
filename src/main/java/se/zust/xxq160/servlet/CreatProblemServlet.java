package se.zust.xxq160.servlet;

import se.zust.xxq160.model.Problem;
import se.zust.xxq160.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "creatProblem",urlPatterns = "/creatProblem")
public class CreatProblemServlet extends HttpServlet {
    TestService testService;
    @Override
    public void init() throws ServletException {
        testService = (TestService) getServletContext().getAttribute("testService");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String back = request.getParameter("back");
        String pType = request.getParameter("pType");
        String info = " ";
        if(pType == null) {
            info = "类型不能为空！";
        }
        else {
            int type = Integer.parseInt(pType);
            String problem = request.getParameter("problem");
            String score = request.getParameter("score");
            if(problem == null || score == null || score == "") {
                info = "题目及分值不能为空";
            }
            else {
                int testId = (int) session.getAttribute("testId");
                String options = "";
                String answer = "";
                String answer2[];
                if(type == 0 || type == 1) {
                    String op[] = {"a", "b", "c", "d"};
                    for(int i=0; i<op.length; i++) {
                        options += request.getParameter(op[i]) + ";";
                    }
                    if(type == 1) {
                        answer2 = request.getParameterValues("answer");
                        for(int i=0; i<answer2.length; i++) {
                            if(answer2[i] != null) {
                                answer += answer2[i];
                            }
                            if(i != answer2.length-1) answer += ",";
                        }
                    }
                    else answer = request.getParameter("answer");
                    if(options == "" || answer == "") {
                        info = "题目选项及答案不能为空";
                    }
                }
                if(info == " ") {
                    int order = (int) session.getAttribute("order");
                    Problem pro = new Problem(testId, type, options, problem, order, answer, Float.parseFloat(score));
                    info = testService.addProblem(order, pro);
                    if(info.equals("添加成功！")) session.setAttribute("order", order+1);
                }
            }
        }
        request.setAttribute("back", back);
        request.setAttribute("info", info);
        request.getRequestDispatcher("WEB-INF/info.jsp").forward(request,response);
    }
}
