/**
 * Link: https://www.hackerrank.com/challenges/beautiful-triplets/problem 
 * All test cases passed!
 * 
 * @author Aniket Bharsakale
 */
public class BeautifulTriplets {

	static int beautifulTriplets(int d, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1, k = j + 1; j < arr.length - 1 && k < arr.length;) {

				if (d != (arr[j] - arr[i])) { // J - I != D
					j++; // if j!=d i.e (j-i) then we move both j & k
					k++;
				} else if (d != (arr[k] - arr[j])) { // K - J != K
					k++;
				} else {
					count++;
					j++;
					k++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 7, 8, 10 };
		System.out.println(beautifulTriplets(3, arr));
	}
}
