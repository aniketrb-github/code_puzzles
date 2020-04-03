/**
 * Link: https://www.hackerrank.com/challenges/counting-valleys/problem
 * All Test cases passed!
 * @author abharsakale
 *
 */
public class CountingValleys {

	static int countingValleys(int n, String str) {
		char[] ch = str.toCharArray();
		int seaLvl = 0, valleyCount = 0;
		for (int i = 0; i < n; i++) {
			if (ch[i] == 'U')
				seaLvl++;
			else
				seaLvl--;
			// 'U' filter is applied, since we need to count the valleys, 
			// i.e when u climb from depth to sea level upwards, your previous step has to be uphill. 
			if (seaLvl == 0 && ch[i]=='U')
				valleyCount++;
		}
		return valleyCount;
	}

	public static void main(String[] args) {

		System.out.println(countingValleys(8, "UDDDUDUU"));			// Expected Ans: 1
		//System.out.println(countingValleys(12, "DDUUDDUDUUUD")); 	// Expected Ans: 2
	}
}
