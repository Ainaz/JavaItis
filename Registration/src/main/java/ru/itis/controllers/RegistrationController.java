package ru.itis.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController implements Controller{
    private UserService userService;

    public RegistrationController() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
        this.userService = (UserService) applicationContext.getBean("userDao");
    }

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if(httpServletRequest.getMethod().equals("GET")){

        }
    }
}
