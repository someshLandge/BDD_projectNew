package Utility_pack;

import java.util.Date;
import java.util.Random;

public class Reusabledata 
{
	public static String Email() {
			
      	return new Date().toString().replace(" ", "").replace(":", "")+("@gmail.com");						
	}
	
	public static String Mobile() {
		
		return "9" + (100000000L + (long) (new Random().nextDouble() * 900000000L));					
	}
	
	
	
}
