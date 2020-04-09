package warm_up;
/**
 * Link: https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 * All test cases passed!
 * 
 * @author Aniket Bharsakale
 */

public class CatAndMouse {

	static String catAndMouse(int a, int b, int c) {
		int diffAC = 0, diffBC = 0;
		diffAC = Math.abs(a - c);
		diffBC = Math.abs(b - c);

		if (diffAC > diffBC)
			return "Cat B";
		else if (diffAC < diffBC)
			return "Cat A";
		else
			return "Mouse C";
	}

	public static void main(String[] args) {
		System.out.println(catAndMouse(1, 2, 3));
		System.out.println(catAndMouse(1, 3, 2));
	}
}
