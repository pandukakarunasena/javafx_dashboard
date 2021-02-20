package database;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1,"panduka", "panadura",34000));
        customerList.add(new Customer(2,"sam", "matara",34000));
        customerList.add(new Customer(3,"john", "galle",34000));
        customerList.add(new Customer(4,"nimal", "kandy",34000));
    }

}
