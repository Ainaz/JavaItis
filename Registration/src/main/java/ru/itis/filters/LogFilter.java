package ru.itis.filters;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.models.User;
import ru.itis.services.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class LogFilter implements Filter{

    private String messageParam;
    private UserService userService;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.messageParam = filterConfig.getInitParameter("message-param");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("CookieBeans.xml");
        this.userService = (UserService) applicationContext.getBean("userService");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain){
        try {
            servletResponse.setContentType("text/html; charset=UTF-8");
            Cookie cookie[] = ((HttpServletRequest) servletRequest).getCookies();
            if (cookie != null) {
                for (int i = cookie.length-1; i > 0; i--) {
                    User user = userService.findUserByToken(cookie[i].getValue());
                    if (user != null) {
                        String token = user.getUserToken();

                        if (cookie[i].getValue().equals(token)) {
                            filterChain.doFilter(servletRequest, servletResponse);
                            break;
                        }
                    }
                }
                servletResponse.getWriter().println("Нет доступа к странице, пожалуйста, авторизуйтесь");
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ServletException e) {
            System.out.println(e);
        }

    }

    public void destroy() {

    }
}
