package servlets;


import factory.ServicesSupportFactory;
import services.OwnersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OwnerServlet extends HttpServlet {
    private OwnersService ownerService;

    @Override
    public void init() throws ServletException {
        super.init();
        ownerService = ServicesSupportFactory.getInstance().getOwnersService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=UTF-8");
        List<String> owners = ownerService.getAllOwners();
        try {
            PrintWriter out = response.getWriter();
            out.println("<h1> Список владельцев: </h1>");
            for(String owner : owners) {
                out.println("<p>" + owner + "</p>");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
