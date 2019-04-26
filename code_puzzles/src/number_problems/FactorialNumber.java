package number_problems;

import java.util.Scanner;

public class FactorialNumber {

	static int originalNum = 0;
	static int factorialResult = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a Number:");
		int inputNum = in.nextInt();
		originalNum = inputNum;
		// Non-Recursive Factorial Program
		factorialNonRecursion(inputNum);

		// Recursive Factorial Program
		System.out.println("Recursive Program for number " + originalNum + " = " + recursiveFactorial(inputNum) );

		in.close();
	}

	private static void factorialNonRecursion(int inputNum) {
		factorialResult = 1;
		while (inputNum > 0) {
			factorialResult = factorialResult * inputNum;
			inputNum--;
		}
		System.out.println("Non-Recursive Program for number " + originalNum + " = " + factorialResult);
	}

	private static int recursiveFactorial(int inputNum) {

		if (inputNum == 0) // Since 0! = 1
			return 1;
		else
			return (inputNum * recursiveFactorial(inputNum - 1));
	}

}
