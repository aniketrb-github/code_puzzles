package other_problems;
/* Explanation to problem:
 * scrambler method accepts the required inputs, String & Integer.
 * Integer for no. of times data scrambling is to be performed. 
 * String upon which data scrambling is to be done.
 * 
 *  I have to iterate over the input string for 'n' times for which we need a loop with counter 'i'
 *  & 2nd nested for loop is required to iterate over the actual input string.
 *  If we find 0 we turn it to 1 & vice versa.
 *  I have my result in char c[] array & I have my original data in char t[] array.
 *  I again compare both original & obfuscated data to find out if data scramble is successful or not
 * 
 */
public class DataScrambling {

	public static void main(String[] args) {
		scrambler("0001100011001010", 20);
	}
	
	static void scrambler(String s, int n) {
		char[] c = s.toCharArray();
		boolean flag = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<c.length; j++) {
				if('0' == c[j]) c[j] = '1';
				else if ('1' == c[j]) c[j] = '0';
			}
		}
		char t[] = s.toCharArray();
		for(int j=0; j<c.length; j++) {
			if(c[j] == t[j]) {flag = true; break;}
		}
		if(flag == true) System.out.println("Deletion failed");
		else System.out.println("Deletion succeeded");
		for (int j = 0; j < c.length; j++) {
			System.out.print(c[j]);
		}System.out.println();
		for (int j = 0; j < t.length; j++) {
			System.out.print(t[j]);
		}
	}

}

/*

problem1:
Jon Marius is the computer expert at his company and has now been tasked to find some software for erasing data properly. It is very important that the data should not be recoverable afterwards, so it should be overwritten on the hard drive several times. Unable to find any free program up to the task, Jon Marius decides to write such a program himself. The user interface is simple, it only asks for the file to be destroyed and n, the number of times it should be overwritten. This number can range from 1 (quick deletion) to 20 (maximum security). Jon Marius processes the file bit by bit and does not consider writing a zero where there was already a zero as really overwriting. So for each of the n sweeps, he overwrites each zero with a one, and each one with a zero, respectively.

Jon Marius knows that independent testing is important, so he has asked you to write the verification routine. He will not listen to your objections to the algorithm so eventually you give in.
Input
The first line of the input contains a single integer 1=N=20. The two following lines each contain a string containing only the characters 0 and 1. The first of these lines represent the bits of the file before deletion and the second the bits on the same position on the hard drive after the file has been deleted. The length of these strings are the same and between 1 and 1000 characters.

Output
Output a single line containing either the words “Deletion succeeded” if each bit is switched N times or “Deletion failed” if this is not the case.

Sample Input 1	
1
10001110101000001111010100001110
01110001010111110000101011110001
Sample Output 1
Deletion succeeded

Sample Input 2	
20
0001100011001010
0001000011000100
Sample Output 2
Deletion failed

*------------------*
Explanation:
Jon is trying to achieve is Data scrambling which is a process of replacing the sensitive data with scrambled data.
It is a irreversible process, wherein one won't be able to derive the original data from the scrambled data which is achieved by overwriting a file.
Input required for the program is the file to be destructed & the n is the number of times the data scrambling operation will be done on the given file, with n=1 be the minimum data obfuscation & n=20 the maximum data obfuscation which implies the max security.

Jon simply replaces every binary bit from 0 to 1 & vice versa for the given file.
However, he has a consideration, only if after n'th iteration, when every binary bit contained in the file is scrambled from 1 to 0 & 0 to 1 then only the data scrambling is successful.
But, If after the data obfuscation operation, if we find the binary bits of the file in an unmodified state, say if 1 remains 1 & 0 remains 0 at any single place, its a failed data scrambling operation.

*/