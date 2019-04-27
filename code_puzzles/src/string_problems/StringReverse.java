package string_problems;

import java.util.Scanner;

/**
 * String = "Hello" -> "olleH"
 * 
 * @author Aniket Bharsakale
 */
public class StringReverse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a String: ");
		String inputString = in.next();

		stringReverseUsingStringOps(inputString);

		stringReverseViaStringBuffer(inputString);

		in.close();
	}

	public static void stringReverseUsingStringOps(String inputString) {
		System.out.println("String Reverse Operation");
		char alphabet;
		String reversedString = "";
		for (int i = inputString.length() - 1; i >= 0; i--) {
			alphabet = inputString.charAt(i);
			reversedString = reversedString + alphabet;
		}
		System.out.println("InputString: " + inputString + "\tReversedString: " + reversedString);
	}

	public static void stringReverseViaStringBuffer(String inputString) {
		System.out.println("\n\nString Reverse Operation using String Buffer");
		StringBuffer buffer = new StringBuffer(inputString);
		System.out.println("InputString: " + inputString + "\tReversedString: " + buffer.reverse());
	}

}
