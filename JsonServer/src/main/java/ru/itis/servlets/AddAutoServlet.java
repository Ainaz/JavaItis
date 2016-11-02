package ru.itis.servlets;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.Auto;
import ru.itis.models.User;
import ru.itis.services.AutoService;
import ru.itis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAutoServlet extends HttpServlet{
    private AutoService autoService;
    private UserService userService;

    @Override
    public  void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("CookieBeans.xml");
        this.userService = (UserService) applicationContext.getBean("userService");
        this.autoService = (AutoService) applicationContext.getBean("autoService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/jsp/addAuto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = 0;
        Cookie cookie[] = request.getCookies();
        for (int i = cookie.length-1; i > 0; i--) {
            User users = userService.findUserByToken(cookie[i].getValue());
            if (users != null)
                if (cookie[i].getValue().equals(users.getUserToken())) {
                    id = users.getUserId();
                    break;
                }
        }

        String autoName = request.getParameter("autoName");
        String number = request.getParameter("autoNumber");
        Auto auto = new Auto(autoName, number, id);

        autoService.addAuto(auto);
        response.sendRedirect("/addAuto");
    }
}
