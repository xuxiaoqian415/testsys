package se.zust.xxq160.servlet;

import se.zust.xxq160.model.User;
import se.zust.xxq160.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String psw = request.getParameter("psw");
        String type= request.getParameter("type");
        String info = " ";
        if(username == null || psw == null || type == null) {
            info = "登录信息不能为空！";
            request.setAttribute("info_log", info);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
            dispatcher.forward(request, response);
        }
        else {
            info = userService.login(username, psw, Integer.parseInt(type));
            request.setAttribute("info_log", info);
            if(info.equals(" ")) {
                List<User> user = userService.searchUsers("username", username, Integer.parseInt(type));
                HttpSession session = request.getSession(true);
                session.setAttribute("thisUser", user.get(0));
                if(user.get(0).getUserType() == 0) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/teacher.jsp");
                    dispatcher.forward(request, response);
                }
            }
            else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
