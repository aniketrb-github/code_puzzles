/**
 * Link: https://www.hackerrank.com/challenges/the-hurdle-race/problem
 * All test cases passed !
 * 
 * @author Aniket Bharsakale
 */
public class HurdleRace {

	static int hurdleRace(int jumpCap, int[] height) {
		int potion = 0;

		for (int i = 0; i < height.length; i++) {
			if (height[i] > jumpCap) {
				potion = potion + (height[i] - jumpCap); // no. of potions required
				jumpCap = height[i]; // update jumping capacity to current hurdle
			} else
				continue;
		}
		return potion;
	}

	public static void main(String[] args) {
		int hurdle1[] = { 1, 3, 4, 5, 11, 4, 1, 12 }; // k=4 | Ans: 8
		int hurdle2[] = { 2, 5, 4, 5, 2 }; // k=7 | Ans: 0
		int hurdle3[] = { 1, 6, 3, 5, 2 }; // k=4 | Ans: 2

		System.out.println("Potions Required: " + hurdleRace(4, hurdle1));
	}
}
