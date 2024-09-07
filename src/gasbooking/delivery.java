package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking{

    public String delPersonName;
    public int customerOtp;

    public Delivery(String name, String street, String area, String pinCode, String mobile, int numberOfCylinders) {
        super(name, street, area, pinCode, mobile, numberOfCylinders);

    }

    //Amount Calculation
    public void amountCalc(){
        long dayDiff = dt_2.getTime() - dt_1.getTime(); 
        long newDiff = TimeUnit.DAYS.convert(dayDiff, TimeUnit.MILLISECONDS);

        if (newDiff > 7){
            refund = 41.25;
            amount = amount - refund;
        }
    }

    public void verifyOtp(){
        if (Status.equals("B")){
            System.out.println("enter OTP : "); //customer otp
            customerOtp = new Scanner(System.in).nextInt();

            if (customerOtp != otp){
                Status = "C";
            }else {
                Status = "D";
            }
        }else {
            System.out.println("No Booking found!!");
        }
    }

    public void delPersonDetails(){
        System.out.println("\n Enter the delivery person name : ");
        delPersonName = new Scanner(System.in).nextLine();
    }

}
