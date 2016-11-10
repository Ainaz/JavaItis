package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.services.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration")
    public ModelAndView showPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationNewUser(@RequestParam("userName") String userName,
                                            @RequestParam("userLogin") String login,
                                            @RequestParam("password") String password){
        ModelAndView modelAndView = new ModelAndView();
        User user = null;

        try {
            user = userService.findUserByLogin(login);
        }catch (NullPointerException e){}

        if(user != null){
            User user1 = new User(userName, login, password.hashCode());
            userService.registrationUser(user1);
            modelAndView.setViewName("login");
        }else{
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
}
