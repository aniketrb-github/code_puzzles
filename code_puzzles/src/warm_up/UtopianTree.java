package warm_up;

/**
 * Link: https://www.hackerrank.com/challenges/utopian-tree/problem
 * All test cases passed!
 * 
 * @author Aniket Bharsakale
 */
public class UtopianTree {
	static int utopianTree(int n) {
		int height = 0;
		for (int count = 0; count <= n; count++) {
			if (count == 0)
				height = 1; // Initial Height
			else if (count % 2 != 0) // Spring Cycle
				height = height * 2;
			else	// Summer Cycle
				height = height + 1;
		}
		return height;
	}

	public static void main(String[] args) {
		System.out.println("growth: " + utopianTree(5));	// 5 -  Ans: 14
		System.out.println("growth: " + utopianTree(4));	// 4 -  Ans: 7
		// 0 - 1
		// 1 - 2
		// 3 - 6
	}
}