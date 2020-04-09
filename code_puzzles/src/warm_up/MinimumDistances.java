/**
 * Link: https://www.hackerrank.com/challenges/minimum-distances All test cases
 * passed !
 * 
 * @author Aniket Bharsakale
 */

public class MinimumDistances {

	static int minimumDistances(int[] a) {
		int minCount = a.length;
		boolean isAtleastOneTriletPresent = false;

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] != a[j])
					continue;
				else if ((j - i) < minCount) {
					minCount = j - i;
					isAtleastOneTriletPresent = true;
				}
			}
		}
		if (isAtleastOneTriletPresent)
			return minCount;
		else
			return -1;
	}

	public static void main(String[] args) {
		int a[] = { 7, 1, 3, 4, 1, 7 };
		System.out.println("Minimum Distance: " + minimumDistances(a)); // Ans: 3

		int b[] = { 1, 2, 3, 4, 10 };
		System.out.println("Minimum Distance: " + minimumDistances(b)); // Ans: -1
	}
}
