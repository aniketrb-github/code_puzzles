package math_problems;
/**
 * Given a number 'n'
 * Iterate the number from 1 -> n
 * Print 'Fizz' if the number is divisible by 3
 * Print 'Buzz' if the number is divisible by 5
 * Print 'FizzBuzz' if the number is divisible by both, 3 & 5
 * 
 * Input : 5
 * Output: 1, 2, Fizz, 4, Buzz
 * 
 * @author Aniket.Bharsakale
 */
public class FizzBuzzProblem {
	
	private static final String FIZZBUZZ = "FizzBuzz";
	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";

	public static void main(String[] args) {
		fizzBuzz(15);
	}

	public static void fizzBuzz(int limit) {
		for (int count = 1; count <= limit; count++) {
			if (count % 3 == 0 && count % 5 == 0)
				System.out.println(FIZZBUZZ);
			else if (count % 3 == 0)
				System.out.println(FIZZ);
			else if (count % 5 == 0)
				System.out.println(BUZZ);
			else
				System.out.println(count);
		}
	}

}
