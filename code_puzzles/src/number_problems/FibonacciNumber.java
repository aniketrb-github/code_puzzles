package number_problems;
/**
 * Fibonacci Number Series
 * Series: 0, 1, 1, 2, 3, 5, 8, 13 . . .
 * 0, 1 initial numbers
 * 
 * 1+0 = 1 which is the 3rd number
 * 1+1 = 2 which results in 4th number
 * 2+1 = 3 which is the 5th number
 * 5+3 = 8 which is the 6th number & so on
 *  
 * @author Aniket Bharsakale
 */
public class FibonacciNumber {
	public static void main(String[] args) {
		System.out.println("Printing Fibonacci Number Series.");
		int a = 0;
		int b = 1;
		int c = 0;
		System.out.println(a);
		for (int i = 0; i < 10; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(c);
		}
	}

}
