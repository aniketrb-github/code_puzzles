package number_problems;

/**
 * Hacker Rank : Find the most minimum & most maximum sum in array. For ex: int
 * arr[] = {1, 2, 3, 4, 5}; minSum = 10, maxSum = 14; If we sum everything
 * except 1, our sum is 14. If we sum everything except 2, our sum is 13. If we
 * sum everything except 3, our sum is 12. If we sum everything except 4, our
 * sum is 11. If we sum everything except 5, our sum is 10.
 * 
 * @author Aniket.Bharsakale
 */
public class MinMaxSum {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		miniMaxSum(arr);
	}

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		int tempArr[] = new int[5];
		int mostMinVal = 0, mostMaxVal = 0, temp = 0;
		System.out.print("Given array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			temp = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				} else {
					temp = temp + arr[j];
				}
			}
			tempArr[i] = temp;
		}
		mostMaxVal = mostMinVal = tempArr[0];
		for (int count = 0; count < tempArr.length; count++) {
			if (tempArr[count] <= mostMinVal) {
				mostMinVal = tempArr[count];
			} else {
				mostMaxVal = tempArr[count];
			}
		}
		System.out.println("\nMost Minimum Sum: " + mostMinVal + "\nMost Maximum Sum: " + mostMaxVal);
	}
}
