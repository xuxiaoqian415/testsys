package se.zust.xxq160.servlet;

import se.zust.xxq160.model.User;
import se.zust.xxq160.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "register",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String school = request.getParameter("school");
        String name = request.getParameter("name");
        String idCard = request.getParameter("idCard");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType");
        String info = " ";
        if(school == null || name == null || idCard == null || username == null || password == null || phone == null || email == null || userType == null) {
            info = "注册信息不能为空！";
            request.setAttribute("info_reg", info);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/register.jsp");
            dispatcher.forward(request, response);
        }
        else {
            List<User> users = userService.allUsers();
            User user = new User(school, name, idCard, username, password, phone, email, Integer.parseInt(userType));
            user.setId();
            info = userService.checkRegister(users, user);
            request.setAttribute("info_reg", info);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
