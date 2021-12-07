package se.zust.xxq160.servlet;

import se.zust.xxq160.model.Class;
import se.zust.xxq160.model.User;
import se.zust.xxq160.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "creatClass",urlPatterns = "/creatClass")
public class CreatClassServlet extends HttpServlet {
    ClassesService classesService;
    @Override
    public void init() throws ServletException {
        classesService = (ClassesService) getServletContext().getAttribute("classesService");
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String cName = request.getParameter("cName");
        String info = " ";
        if(cName == null) {
            info = "班级名称不能为空！";
            request.setAttribute("info_addC", info);
        }
        else {
            HttpSession session = request.getSession(true);
            int t_id = ((User) session.getAttribute("thisUser")).getId();
            String t_name = ((User) session.getAttribute("thisUser")).getName();
            Class cla = new Class(cName, t_id ,t_name, 0);
            cla.setId();
            List<Class> classes = classesService.searchClasses_t(t_id);
            info = classesService.addClass(classes, cla);
            request.setAttribute("info_addC", info);
        }
        request.getRequestDispatcher("WEB-INF/teacher.jsp").forward(request,response);
    }
}
