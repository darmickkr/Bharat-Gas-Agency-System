package gasSupplier;

public interface gasAgency {
	    public String agencyName = "Bharat Gas";
	    public int agencyCode = 1234;
	    public int phNumber = 783555; 

	    public int pinCode = 201310;

	  
	    default void agencyDisplay(){
	        System.out.println("The Agency Name is : " + agencyName);
	        System.out.println("The Agency Code is : " + agencyCode);
	        System.out.println("The Agency Helpline number is : " + phNumber);
	    }


	}


