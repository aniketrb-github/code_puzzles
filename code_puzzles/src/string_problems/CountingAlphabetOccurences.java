package string_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * String = "Hellooo" -> {H=1, e=1, l=2, o=3}
 * 
 * @author Aniket.Bharsakale
 */
public class CountingAlphabetOccurences {

	private static final int TOTAL_NUMBER_OF_ALPHABETS = 26;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the input string: ");
		String inputString = in.next();

		Map<Character, Integer> charactersMap = new HashMap<>(
				Math.min(inputString.length(), TOTAL_NUMBER_OF_ALPHABETS));
		Character alphabet;
		for (int i = 0; i < inputString.length(); i++) {
			alphabet = inputString.charAt(i);

			// if map does not contain this alphabet, hence its the first encounter
			if (!charactersMap.containsKey(alphabet)) {
				charactersMap.put(alphabet, 1);
			} else {
				// on encountering the character again, we increment the existing count
				charactersMap.put(alphabet, charactersMap.get(alphabet) + 1);
			}
		}
		System.out.println("\nCharacter Count Program: " + charactersMap);
		in.close();
	}

}
