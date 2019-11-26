package arb_test_demo;

/**
 * Kangaroo Problem: https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=false&h_r=next-challenge&h_v=zen
 * 
 * @author abharsakale
 */
public class KangarooProblem {

	final private static String YES = "YES";
	final private static String NO = "NO";

	public static void main( String[] args ) {
		System.out.println( kangaroo( /*0, 3, 4, 2*/ /*21, 6, 47, 3*/ /*0, 2, 5, 3*/28, 8, 96, 2 ) );
	}

	static String kangaroo( int x1, int v1, int x2, int v2 ) {
		int a = x1 + v1;
		int b = x2 + v2;
		int x = 0;
		String flag = NO;
		if ( ( x1 < x2 && v1 < v2 ) ) {
			return NO;
		}
		else if ( ( x1 > x2 || x1 < x2 ) && ( v1 == v2 ) ) {
			return NO;
		}
		else if ( x1 == x2 ) {
			return YES;
		}
		else {
			while ( x < 10000 || ( a % b == 0 ) ) {
				if ( a == b ) {
					return YES;
				}
				a = a + v1;
				b = b + v2;
				x++;
			}
		}
		return flag;
	}

}
