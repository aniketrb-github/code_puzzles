package string_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * MindReader: Twitterize
 * 
 * In Twitter, you are allowed only 140 characters to express your thoughts. To
 * be able to use these 140 characters as effectively as possible we derived the
 * following "compression" scheme, inspired by the words i18n and l10n:
 * 
 * from a given word take the first and the last letter, then count the number
 * of letter between the first and the last letter, finally, create a new string
 * consisting of the first letter, the number of characters in between and the
 * last letter.
 * 
 * For instance, the world "internationalization" thus becomes "i18n" and the
 * word "lano" becomes "l2o". 
 * ex :I/P: hello there you 
 * O/P:h3o t3o y1u
 * 
 * @author Aniket Bharsakale
 */
public class Twitterize {

	public final static Integer FIRST_CHAR_INDEX = 0;
	public final static Integer MINUS_CHAR = 2;
	
	public static void main(String arg[]) {
		String inputString = "Hello you there. I am Aniket!!! Nice to meet u.";
		StringTokenizer tokenizer = new StringTokenizer(inputString);

		String wordToken = null;
		char startAlphabet;
		char lastAlphabet;
		List<String> resultOutput = new ArrayList<>();
		int middleAplhabetsCount = 0;
		while (tokenizer.hasMoreTokens()) {
			wordToken = tokenizer.nextToken();
			// filters out the special characters from the token using a regular expression
			wordToken = wordToken.replaceAll("[^a-zA-Z0-9]","");
			// get 1st alphabet
			startAlphabet = wordToken.charAt(FIRST_CHAR_INDEX);
			// get last alphabet
			lastAlphabet = wordToken.charAt(wordToken.length() - 1);
			
			if (wordToken.indexOf(startAlphabet) != wordToken.indexOf(lastAlphabet)) {
				// as per the qun. u need 2 chars, i.e start & end char. i.e total 2 chars
				middleAplhabetsCount = wordToken.length() - MINUS_CHAR;
				resultOutput.add(startAlphabet + "" + middleAplhabetsCount + "" + lastAlphabet);
			} else {
				// when its just an alphabet in the sentence like: "Hi, I am Aron" -> H0i I a0m A2n
				resultOutput.add(startAlphabet + "");
			}
		}
		
		System.out.println("Input String: "+inputString);
		System.out.println("Output Result: "+resultOutput);
		
	}
}
