package warm_up;

import java.util.Scanner;

/**
 * Link: https://www.hackerrank.com/challenges/repeated-string/problem
 * 
 * @author Aniket.Bharsakale
 */
public class RepeatedString {
    
	static long repeatedString(String s, long n) {
		StringBuilder sb = new StringBuilder(s);
		char[] chArr = s.toCharArray();

		while (sb.length() < n) {
			for (Integer i = 0; i < chArr.length; i++)
				if (sb.length() < n)
					sb.append(chArr[i]);
				else
					break;
		}
		System.out.println("Target String: " + sb.toString());
		char[] c = sb.toString().toCharArray();
		long count = 0;
		int k = 0;
		while (k < c.length) {
			if (c[k] == 'a') {
				count++;
			}
			k++;
		}
		return count;
	}

	private static final String INPUT_STRING = "abaca";
    
	public static void main(String[] args) {

		System.out.println("My Trial\n" + repeatedString(INPUT_STRING, 10L));

		System.out.println("Actual Solution: \n");
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter any String: ");
		String s = in.next();
		System.out.println("Please enter a integer number: ");
		long n = in.nextLong();
		long num = n / s.length();
		long rem = n % s.length();
		long ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				ans += num;
				if (i < rem)
					ans++;
			}
		}
		System.out.println(ans);
		in.close();
	}
}
