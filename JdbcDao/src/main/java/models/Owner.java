package models;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class Owner {

    private int id;
    private String name;
    private int age;
    private String city;

    public Owner(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
