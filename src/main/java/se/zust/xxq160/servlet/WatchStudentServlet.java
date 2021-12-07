package se.zust.xxq160.servlet;

import se.zust.xxq160.model.User;
import se.zust.xxq160.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "watchStu",urlPatterns = "/watchStu")
public class WatchStudentServlet extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=request.getParameter("cid");
        HttpSession session=request.getSession();
        session.setAttribute("cid",cid);
        List<User> users = userService.searchStu(Integer.parseInt(cid));
        request.setAttribute("users",users);
        request.getRequestDispatcher("WEB-INF/watchStu.jsp").forward(request,response);

    }
}
