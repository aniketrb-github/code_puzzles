package number_problems;
/**
 * Find the 2nd Maximum number from the given Integer Array
 * @author Aniket Bharsakale
 */
public class Find2ndMaxNumber {
	public static void main(String[] args) {
		int intArray[] = { 9, 8, 1, 13, 22, 11, 24, 10 };

		int max1 = 0;
		int max2 = 0;

		// initial assuming the max1 & max2
		if (intArray[0] > intArray[1]) {
			max1 = intArray[0];
			max2 = intArray[1];
		} else {
			max1 = intArray[1];
			max2 = intArray[0];
		}

		// finding out the 2nd maximum number in an integer array
		for (int i = 2; i < intArray.length; i++) {

			// update the max1 if another max number is found in array
			if (intArray[i] > max1) {

				max2 = max1; // v.v.v.imp ! that we write this before the below line of code
				max1 = intArray[i];

			} else if (intArray[i] > max2) {

				max2 = intArray[i];

			}
		}

		System.out.println("1st Maximum Number in array: " + max1);
		System.out.println("2nd Maximum Number in array: " + max2);
	}

}