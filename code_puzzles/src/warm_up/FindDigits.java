package warm_up;

/**
 * Link: https://www.hackerrank.com/challenges/find-digits/problem
 * 2 of 2 test cases passed!
 * @author Aniket.Bharsakale
 */
public class FindDigits {

	static int findDigits(int num) {
		int count = 0, digit = 0, temp = num;
		while (temp > 0) {
			digit = temp % 10;
			temp = temp / 10;
			if (digit != 0 && num % digit == 0)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findDigits(12));
		System.out.println(findDigits(1012));
	}
}
