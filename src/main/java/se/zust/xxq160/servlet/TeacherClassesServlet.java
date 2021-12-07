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

@WebServlet(name = "tClasses",urlPatterns = "/tClasses")
public class TeacherClassesServlet extends HttpServlet {
    ClassesService classesService;
    @Override
    public void init() throws ServletException {
        classesService = (ClassesService) getServletContext().getAttribute("classesService");
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Integer t_id = ((User) session.getAttribute("thisUser")).getId();
        List<Class> classes = classesService.searchClasses_t(t_id);
        request.setAttribute("classes", classes);
        request.getRequestDispatcher("WEB-INF/teacher.jsp").forward(request,response);
    }
}
