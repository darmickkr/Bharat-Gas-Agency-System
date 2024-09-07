package gasBooking;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import Customers.GasConnection;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {

    public double otp = 5678;
    public double amount = 825.0;
    public double refund = 0.0;

    public String dt, delDate, Status, DelMobileNo = "7838048546";

    public Date dt_1,dt_2;

    //constructor
    public Booking(String name, String street, String area, String pinCode, String mobile, int numberOfCylinders) {
        super(name, street, area, pinCode, mobile, numberOfCylinders);
    }

    //
    public void getDates(){
        System.out.println("enter booking date: ");
        dt = new Scanner(System.in).nextLine(); 
        dt_1 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt_1 = dateFormat.parse(dt);
        }catch (ParseException e){
            System.out.println("error in getDates function"+e);
        }

        
        System.out.println("Enter Delivery Date : ");
        delDate = new Scanner(System.in).nextLine();
        try{
            dt_2 = dateFormat.parse(delDate);
        }catch(Exception e){
            System.out.println("Error parsing dt_2: "+e);
        }

      
        try{
            long difference = dt_2.getTime() - dt_1.getTime();

            //difference in days
            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
            if (newDifference > 7){
                Status = "P"; //Pending status
            }
        }catch(Exception e){
            System.out.println("Error while finding the difference : "+ e);
        }

    }

    //Validate function
    public void validate(){
        //get the difference between two dates
        long elapsedms = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);

        //Print the difference from lastdate of booking to current date of booking
        System.out.println("difference between two dates is : " + diff);

        if (numberOfCylinders == 1){
            // for Single Cylinder
            if (diff<30){
                System.out.println("booking cannot be done");
//                numberOfCylinders
                Status = "C"; //status canceled
            }else {
                Status = "B"; 
                lastDate = dt_1; 
            }
        } else if (numberOfCylinders == 2) {
            // For Double Cylinder
            if (diff<50){
                System.out.println("booking cannot be done");
//                numberOfCylinders
                Status = "C"; //status canceled
            }else {
                Status = "B"; //status booked
                lastDate = dt_1;
            }

        }
    }


}
