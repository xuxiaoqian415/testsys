package se.zust.xxq160.servlet;

import se.zust.xxq160.model.User;
import se.zust.xxq160.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "joinClass",urlPatterns = "/joinClass")
public class JoinClassServlet extends HttpServlet {
    ClassesService classesService;
    @Override
    public void init() throws ServletException {
        classesService = (ClassesService) getServletContext().getAttribute("classesService");
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String cid = request.getParameter("cid");
        String info = " ";
        if(cid == null || cid == "") {
            info = "班级ID不能为空！";
            request.setAttribute("info_joinC", info);
        }
        else {
            HttpSession session = request.getSession(true);
            int sid = ((User) session.getAttribute("thisUser")).getId();
            info = classesService.joinClass(sid, Integer.parseInt(cid));
            request.setAttribute("info_joinC", info);
        }
        request.getRequestDispatcher("WEB-INF/student.jsp").forward(request,response);
    }
}
