package number_problems;

/**
 * There are 3 integer arrays having O(n) complexity. Find the first common
 * number present in all the given 3 arrays. PS: All 3 arrays are sorted in
 * ascending order
 * 
 * @author Aniket.Bharsakale
 */
public class FindCommonNumber {
	public static void main(String[] args) {
		// Initial Input Data
		int a[] = { -1, 5, 10, 20, 40, 80 };
		int b[] = { 7, 20, 80, 100 };
		int c[] = { -4, 15, 20, 70, 80 };

		int i = 0; // array a's counter variable
		int j = 0; // array b's counter variable
		int k = 0; // array c's counter variable
		boolean flag = false;

		// condition: until we reach the end of any array, exit the play!
		while (i < a.length && j < b.length && k < c.length) {

			if (a[i] == b[j] && b[j] == c[k] && a[i] == c[k]) {
				flag = true;
				break;

			} else if (a[i] < b[j]) {
				i++;
			} else if (b[j] < c[k]) {
				j++;
			} else if (c[k] < a[i]) {
				k++;
			}
		}

		if (flag)
			System.out.println(a[i] + " is the common number in all 3 arrays !!!!!!");
		else
			System.out.println("There is NOO common number in all 3 arrays!");
	}
}
