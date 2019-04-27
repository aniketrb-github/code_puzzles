package number_problems;

import java.util.Scanner;
/**
 * The Sum of Cube of each digit is added & if the result of this operation
 * is same as that of the initial number, then we call it as an Armstrong's Number 
 * 153 = (1x1x1) + (5x5x5) + (3x3x3)
 * @author Aniket Bharsakale
 */
public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter any desired number:");
		Integer inputNum = in.nextInt();
		Integer originalNum = inputNum;
		int temp = 0;
		int result = 0;
		while (inputNum > 0) {
			temp = inputNum % 10;
			result = result + (temp * temp * temp);
			inputNum = inputNum / 10;
		}

		System.out.println("calculated result: " + result);

		if (originalNum == result)
			System.out.println(originalNum + " is an Amrstrong's Number");
		else
			System.out.println(originalNum + " is NOT an Amrstrong's Number");

		in.close();
	}
}
