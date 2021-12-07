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
import java.util.List;

@WebServlet(name = "thisTest",urlPatterns = "/thisTest")
public class ThisTestServlet extends HttpServlet {
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
        Boolean completed = testService.ifCompleted(stuid, testid);
        if(!completed) {
            List<Problem> Problems = testService.searchProblemBytid(testid);
            for (Problem p:Problems){
                String options=p.getOptions();
                p.setOps( options.split(";"));
            }
            int time = testService.getTime(testid);
            request.setAttribute("time", time);
            request.setAttribute("problems", Problems);
            request.getRequestDispatcher("WEB-INF/thisTest.jsp").forward(request,response);
        }
        else {
            request.setAttribute("back","testOnline");
            request.setAttribute("info", "已提交过该试卷！");
            request.getRequestDispatcher("WEB-INF/info.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer stuid = (Integer) session.getAttribute("stuid");
        Integer testid = (Integer) session.getAttribute("testid");
        String info = " ";
        float objGrade = 0;
        //将答案放入stuanswer,计算客观题成绩并放入数据库
        List<Problem> Problems = testService.searchProblemBytid(testid);
        String subjAns[] = new String[]{"",""};
        int c = 0;
        String objAnswers = "";
        for (Problem p:Problems) {
            int type = p.getPtype();
            int order = p.getOrder();
            String answer = "";
            String answer2[];
            if(type == 1) {
                //获取学生提交的多选题答案
                answer2 = request.getParameterValues(String.valueOf(order));
                int l = answer2.length;
                for(int i=0; i<l; i++) {
                    if(answer2[i] != null) {
                        answer += answer2[i];
                    }
                    if(i != l-1) answer += ",";
                }
                //算分
                if(answer.equals(p.getAnswer()))
                    objGrade += p.getScore();
            }
            else {
                //获取学生提交的单选题或多选题答案
                answer = request.getParameter(String.valueOf(order));
                if(type == 0) {
                    //算分
                    if(answer.equals(p.getAnswer()))
                        objGrade += p.getScore();
                }
            }
            //将每道题答案放入临时数组，客观题连接成字符串
            if(type==0 || type == 1){
                objAnswers += answer+";";
            }
            else if(type == 2){
                subjAns[c] = answer;
                c++;
            }
        }
        //在数据库中创建学生答案元组
        info = testService.addStuAns(testid, stuid);
        //将客观题答案存入数据库
        info = testService.updateOptions(testid, stuid, objAnswers);
        //将主观题答案存入数据库
        info = testService.updateSubjAns(testid, stuid, subjAns);
        //将客观题成绩存入数据库
        info = testService.setObjGrade(testid, stuid, objGrade);
        info += "你的客观题成绩是：" + objGrade;
        //已提交人数加一
        testService.setSub(testid);
        request.setAttribute("info2", info);
        doGet(request,response);
    }
}
