package number_problems;
/**
 * Power of a Number program
 * @author Aniket Bharsakale
 */
public class PowerOfNumber {

	public static void main(String[] args) {
		System.out.println("UserDefinedPowerFunction = 5^5: "+UserDefinedPowerFunction(5, 5));
		
		System.out.println("Math.POW() = 5^5: "+Math.pow(5, 5));
	}
	
	public static double UserDefinedPowerFunction(double base, double power) {
		double result = 1;
		for (int count = 0; count < power; count++) {
			result = result * base;
		}
		return result;
	}

}
