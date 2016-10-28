package ru.itis.servlets;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.Auto;
import ru.itis.models.User;
import ru.itis.services.AutoService;
import ru.itis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet{
    private UserService userService;
    private AutoService autoService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("CookieBeans.xml");
        this.userService = (UserService) applicationContext.getBean("userService");
        this.autoService = (AutoService) applicationContext.getBean("autoService");
    }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html; charset=UTF-8");
            List<User> users = userService.getAllUsers();
            List<Auto> autos = autoService.getAllAuto();
            request.setAttribute("Users", users);
            request.setAttribute("Autos", autos);

            getServletContext().getRequestDispatcher("/jsp/list.jsp").forward(request, response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/addAuto");
    }
}
