package servlets;

import factory.ServicesSupportFactory;
import models.Car;
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
        try {
            response.setContentType("text/html; charset=UTF-8");
            List<Car> cars = carsService.getAllCars();

            request.setAttribute("Cars", cars);

            getServletContext().getRequestDispatcher("/cars.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
}
