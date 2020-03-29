package warm_up;

/**
 * Link: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 * 
 * @author Aniket.Bharsakale
 */
public class DivisibleSumPairs {

	static void divisibleSumPairs(int n, int k, int[] ar) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++)
				if (((ar[i] + ar[j]) % k) == 0)
					count++;
		}
		System.out.println("There can be '" + count + "' many pairs.");
	}

	public static void main(String[] args) {
		int set1[] = { 1, 3, 2, 6, 1, 2 }; // n = 6, k = 3, Expected Answer: 5 pairs
		int set2[] = { 1, 2, 3, 4, 5, 6 }; // n = 6, k = 5, Expected Answer: 3 pairs

		divisibleSumPairs(set2.length, 5, set2);
	}
}
