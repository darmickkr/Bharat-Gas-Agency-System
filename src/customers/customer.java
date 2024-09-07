package Customers;
import gasSupplier.gasAgency;

public class Customer implements gasAgency {

    public String name;
    public String street;
    public String area;
    public String pinCode;
    public String mobile;

    //Constructor
    public Customer(String name, String street, String area, String pinCode, String mobile) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.pinCode = pinCode;
        this.mobile = mobile;
    }
}
