package warm_up;

/**
 * Link: https://www.hackerrank.com/challenges/angry-professor/problem
 * All test passed!
 * 
 * @author Aniket Bharsakale
 */
public class AngryProfessor {

    private static final String YES = "YES";
    private static final String NO = "NO";

    static String angryProfessor(int minRequired, int[] a) {
        int minCount = 0;
        for(int i=0; i<a.length; i++) {
            if(a[i] <= 0)
                minCount++;
        }
        if(minCount >= minRequired)
            return NO;
        else
            return YES;
    }

	public static void main(String[] args) {
		int a[] = { -1, -3, 4, 2 };		// Threshold: 3
		int b[] = { 0, -1, 2, 1 };		// Threshold: 2
		System.out.println("Class cancelled: "+ angryProfessor(3, a));
	}
}
