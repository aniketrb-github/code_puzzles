package string_problems;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Select a Word(X) with highest count from given statement. Create a Numeric
 * String by appending length of the Successor & Predecessor word of that word (X) to a result string.
 * ex. India is my, country. India is the best country. I live in India. India is in Asia. Mr Modi is the prime minister of India.
 * result = "272222"
 * 
 * @author Aniket.Bharsakale
 */
public class CountWordOccurences {

	public static void main(String[] args) {

		String testString = "India is my, country. India is the best country. I live in India. India is in Asia. Mr Modi is the prime minister of India.";
		
		//testString = "My name is Aniket. Aniket is a good boy. Aniket knows to play cricket, football, T.T. Aniket lives in India.";
		
		// Removing the unwanted characters
		testString = testString.replace(".", "");
		testString = testString.replace(",", "");
		testString = testString.replace("!", "");

		// Splitting the statement based on space key
		String splitWords[] = testString.toLowerCase().split(" ");

		// Map to Store the Words against their Count (K,V)
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

		for (String word : splitWords) {
			if (wordCountMap.containsKey(word)) {
				wordCountMap.put(word, wordCountMap.get(word) + 1);
			} else {
				wordCountMap.put(word, 1);
			}
		}

		Integer count = 0;
		String mostRepeatedWord = null;

		// Iterate the map to get the highest count
		Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() > count) {
				mostRepeatedWord = entry.getKey();
				count = entry.getValue();
			}
		}

		System.out.println("Most Repeated Word : " + mostRepeatedWord + "\nNumber Of Occurrences : " + count);

		StringBuilder result = new StringBuilder();
		String prevWord = null;
		String currentWord = null;
		String nextWord = null;

		// Checking the Predecessor & the Successor words to append & create the result string
		for (int counter = 0; counter < splitWords.length; counter++) {
			currentWord = splitWords[counter];

			if (counter != splitWords.length - 1)
				nextWord = splitWords[counter + 1];
			else
				nextWord = null;

			if (currentWord.equalsIgnoreCase(mostRepeatedWord)) {
				if (null != prevWord && !prevWord.equals(mostRepeatedWord))
					result.append(prevWord.length());

				if (null != nextWord && !nextWord.equals(mostRepeatedWord))
					result.append(nextWord.length());
			}

			prevWord = currentWord;
		}

		System.out.println("Resultant Numeric String : " + result);
	}

}
