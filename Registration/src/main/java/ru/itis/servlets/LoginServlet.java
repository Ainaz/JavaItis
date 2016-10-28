package ru.itis.servlets;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.User;
import ru.itis.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class LoginServlet extends HttpServlet{
    private UserService userService;
    private SecureRandom random = new SecureRandom();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("CookieBeans.xml");
        this.userService = (UserService) applicationContext.getBean("userService");
    }

    public String nextSessionId() {
        return new BigInteger(100, random).toString(32);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String token = null;

        String login = request.getParameter("userLogin");
        int password = request.getParameter("password").hashCode();

        User user = userService.findUserByLogin(login);

        if (user != null) {
            if (user.getUserPassword() == password) {
                token = nextSessionId();
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(5 * 60); // пять минут
                response.addCookie(cookie);
                userService.updateUser(token, user.getUserId());
            }
        }

        if (token == null) {
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/list");
        }
    }
}
