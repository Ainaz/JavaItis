package models;

public class Car {

    private int id;
    private String name;
    private int mileage;

    public Car(int id, String name, int mileage) {
        this.id = id;
        this.name = name;
        this.mileage = mileage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }


}
