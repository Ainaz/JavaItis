import factory.ServicesSupportFactory;
import models.Owner;
import services.OwnersService;


public class Main {
    public static void main(String[] args) {
        OwnersService ownersService = ServicesSupportFactory.getInstance().getOwnersService();
        ownersService.getAllOwners();
        System.out.println();

    }
}
