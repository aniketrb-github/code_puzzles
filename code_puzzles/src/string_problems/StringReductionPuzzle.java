package string_problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
Given a string consisting of the letters a, b  and c, we can perform the following operation:

Take any two adjacent distinct characters and replace them with the third character.
Find the shortest string obtainable through applying this operation repeatedly.

For example, given the string "aba" we can reduce it to a 1 character string by replacing  ab with c and ca with b.
aba -> ca ->b

Input 
cab  
bcab  
ccccc

Output
2
1
5


 * @author Aniket.Bharsakale
 */
public class StringReductionPuzzle {

	public static void main(String[] args) throws FileNotFoundException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("stringReductionInput.txt"))) {
			List<String> input = reader.lines().collect(Collectors.toList());
			for(String s : input) {
				System.out.println(stringReduction(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	static int stringReduction(String str) {
		String temp = "";
		char charArr[];
		while (str.contains("ab") || str.contains("ba") || str.contains("bc") || str.contains("cb")
				|| str.contains("ac") || str.contains("ca")) {
			charArr = str.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				if (i + 1 < charArr.length) {
					if (charArr[i] != charArr[i + 1]) {
						if (charArr[i] == 'a' && charArr[i + 1] == 'b') {
							temp = str.replaceFirst("ab", "c");
						} else if (charArr[i] == 'b' && charArr[i + 1] == 'a') {
							temp = str.replaceFirst("ba", "c");
						} else if (charArr[i] == 'b' && charArr[i + 1] == 'c') {
							temp = str.replaceFirst("bc", "a");
						} else if (charArr[i] == 'c' && charArr[i + 1] == 'b') {
							temp = str.replaceFirst("cb", "a");
						} else if (charArr[i] == 'a' && charArr[i + 1] == 'c') {
							temp = str.replaceFirst("ac", "b");
						} else if (charArr[i] == 'c' && charArr[i + 1] == 'a') {
							temp = str.replaceFirst("ca", "b");
						}
						str = temp;
						break;
					}
				}
			}
		}
		return str.length();
	}
}
