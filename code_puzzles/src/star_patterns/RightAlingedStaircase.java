package star_patterns;
/**
	HackerRank: Right aligned staircase problem
	Given n=4 then print following pattern:
				   #
				  ##
				 ###
				####

 * @author Aniket.Bharsakale
 */
public class RightAlingedStaircase {
	private final static String SPACE = " ";
	private final static String HASH = "#";

	public static void main(String[] args) {
		staircase(6);
	}

	static void staircase(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(SPACE);
			}
			for (int k = 0; k <= i; k++) {
				System.out.print(HASH);
			}
			System.out.println();
		}
	}
}
