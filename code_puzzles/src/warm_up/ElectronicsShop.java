package warm_up;
/**
 * Link: https://www.hackerrank.com/challenges/electronics-shop/problem
 * All test cases passed !
 * 
 * @author Aniket Bharsakale
 */
public class ElectronicsShop {

	static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
		int maxAmt = -1, totalAmt = 0;
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				totalAmt = keyboards[i] + drives[j];
				if (totalAmt <= budget && totalAmt >= maxAmt)
					maxAmt = totalAmt;
			}
		}
		return maxAmt;
	}

	public static void main(String[] args) {
		int kb1[] = { 4 };
		int dr1[] = { 5 };
		int kb2[] = { 3, 1 };
		int dr2[] = { 5, 2, 8 };

		System.out.println(getMoneySpent(kb1, dr1, 5));
		System.out.println(getMoneySpent(kb2, dr2, 10));
	}
}
