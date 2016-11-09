package ru.itis.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.models.Auto;
import ru.itis.models.User;
import ru.itis.services.AutoService;
import ru.itis.services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAutoController implements Controller{
    private AutoService autoService;
    private UserService userService;

    public AddAutoController() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
        this.userService = (UserService) applicationContext.getBean("userService");
        this.autoService = (AutoService) applicationContext.getBean("autoService");
    }

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if(httpServletRequest.getMethod().equals("GET")){
            //ModelAndView modelAndView = new ModelAndView();
            //modelAndView.setViewName("addAuto");
        }else if(httpServletRequest.getMethod().equals("POST")){
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

        }
    }
}
