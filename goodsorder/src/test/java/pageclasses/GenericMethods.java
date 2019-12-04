package pageclasses;

public class GenericMethods {
	
	
public static String trimString(String x) {
		
		x = x.trim().replace(",", ".");
		
		
		return x;
		
	} 
	
	public static double convertStringToDouble(String x) {
		
		double value = Double.parseDouble(x);
		return value;
	} 
	public static boolean compareDouble(double a, double b) {
		
		boolean value;
		if (a == b) {
			value = true;
		return	value;
			 
		} else {
			value = false;
		return value;}
	} 

}
