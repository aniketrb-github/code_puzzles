package warm_up;

import java.util.Arrays;
import java.util.List;

/**
 * Link: https://www.hackerrank.com/challenges/the-birthday-bar/problem
 * 
 * @author Aniket.Bharsakale
 */
public class ChocklateBar {

	static void birthday(List<Integer> cadbury, int day, int month) {
		int res = 0, count = 0;
		for (int i = 0; i < cadbury.size(); i++) {
			for (int j = 0; j < month; j++) {
				if (i + j < cadbury.size()) {
					res += cadbury.get(i + j);
					if (res == day && j == month - 1)
						count++;
				}
			}
			res = 0;
		}
		System.out.println("There can be '"+count+"' possible divisions of the given chocklate bar.");	
	}

	public static void main(String[] args) {
		List<Integer> milkyBar = Arrays.asList(1, 2, 1, 3, 2);		// 3,2 - Ans: 2
		List<Integer> cadbury = Arrays.asList(1, 1, 1, 1, 1, 1);	// 3,2 - Ans: 0
		List<Integer> fiveStar = Arrays.asList(2, 2, 1, 3, 2);		// 4,2 - Ans: 2
		birthday(fiveStar, 4, 2);
	}
}
