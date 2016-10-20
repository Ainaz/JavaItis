import factory.ServicesSupportFactory;
import models.Owner;
import services.CarsService;
import services.OwnersService;


public class Main {
    public static void main(String[] args) {
        OwnersService ownersService = ServicesSupportFactory.getInstance().getOwnersService();
        CarsService carsService = ServicesSupportFactory.getInstance().getCarsService();
        ownersService.getAllOwners();
        System.out.println();
        carsService.getAllCars();

    }
}
