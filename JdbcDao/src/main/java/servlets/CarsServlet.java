package servlets;

import factory.ServicesSupportFactory;
import services.CarsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CarsServlet extends HttpServlet{
    private CarsService carsService;

    @Override
    public void init() throws ServletException {
        super.init();
        carsService = ServicesSupportFactory.getInstance().getCarsService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=UTF-8");
        List<String> cars = carsService.getAllCars();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("<h1> Список владельцев: </h1>");
            for(String car : cars) {
                out.println("<p>" + car + "</p>");
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
