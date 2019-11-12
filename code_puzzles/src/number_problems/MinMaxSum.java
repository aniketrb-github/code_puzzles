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
		//long arr[] = { 256741038, 623958417, 467905213, 714532089, 938071625};
		//long arr[] = { 396285104, 573261094, 759641832, 819230764, 364801279 };
		//long arr[] = {140638725, 436257910, 953274816, 734065819, 362748590};
		//long arr[] = {769082435 ,210437958, 673982045, 375809214 ,380564127};
		// long arr[] = {793810624, 895642170, 685903712, 623789054, 468592370};
		long arr[] = {140537896, 243908675, 670291834, 923018467, 520718469};
		//long arr[] = {1, 2, 3, 4, 5};
		miniMaxSum(arr);
	}

	// Complete the miniMaxSum function below.
	static void miniMaxSum(long[] arr) {
		long tempArr[] = new long[5];
		long mostMinVal = 0, mostMaxVal = 0, temp = 0;
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
		System.out.println("Temp Array: ");
		for (int count = 0; count < tempArr.length; count++) {
			System.out.print(tempArr[count] + " ");
			if (tempArr[count] <= mostMinVal) {
				mostMinVal = tempArr[count];
			} else if (tempArr[count] >= mostMaxVal) {
				mostMaxVal = tempArr[count];
			}
		}
		System.out.println("\nMost Minimum Sum: " + mostMinVal + "\nMost Maximum Sum: " + mostMaxVal);
	}
}
