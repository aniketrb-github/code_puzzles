/**
 * Link: https://www.hackerrank.com/challenges/sock-merchant/problem
 * All Test cases passed!
 * @author Aniket Bharsakale
 */
public class SockMerchant {

	static int sockMerchant(int n, int[] ar) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (ar[i] == -1 || ar[j] == -1) {
					continue;
				} else if (ar[i] == ar[j]) {
					count++;
					ar[i] = -1;
					ar[j] = -1;
				}
			}
		}
		System.out.println("Count: " + count);
		return count;
	}

    public static void main(String[] args) {
        //int ar[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    	int ar[] = {6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5};
        System.out.println(sockMerchant(ar.length, ar));
    }
}
