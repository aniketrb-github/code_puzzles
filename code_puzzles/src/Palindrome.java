import java.util.Scanner;

public class Palindrome {
	public static void main(String args[]) {
		int inputNum = 0;
		int tempNum = 0;
		int originalNum, reverseNum = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter any number:");
		inputNum = s.nextInt();
		originalNum = inputNum;
		
		while (inputNum > 0) {
			tempNum = inputNum % 10;
			reverseNum = (reverseNum * 10) + tempNum;
			inputNum = inputNum / 10;
		}
		
		if (reverseNum == originalNum) {
			System.out.println("Given number " + originalNum + " is Palindrome");
		} else {
			System.out.println("Given number " + originalNum + " is Not Palindrome");
		}
		
		s.close();
	}
}