package other_problems;

/**
 * Apple Orange Problem: https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=false
 * 
 * @author abharsakale
 */
public class AppleOrangeProblem {

	public static void main( String[] args ) {
		int apples[] = { -2, 2, 1 };
		int oranges[] = { 5, -6 };
		countApplesAndOranges( 7, 11, 5, 15, apples, oranges );
	}

	static void countApplesAndOranges( int s, int t, int appleTreeloc, int orangeTreeLoc, int[] apples, int[] oranges ) {
		System.out.println( "Sam's House Ranges from: " + s + " -- to -- " + t );
		int appLoc[] = fruitLocationFinder( apples, appleTreeloc );
		int orgLoc[] = fruitLocationFinder( oranges, orangeTreeLoc );
		System.out.println( "Apples fell on Sam's house: " + fruitCatcher( appLoc, s, t ) );
		System.out.println( "Oranges fell on Sam's house: " + fruitCatcher( orgLoc, s, t ) );
	}

	static int[] fruitLocationFinder( int fruit[], int treeLoc ) {
		int fruitLoc[] = new int[fruit.length];
		for ( int i = 0; i < fruit.length; i++ ) {
			fruitLoc[i] = treeLoc + fruit[i];
			System.out.print( fruitLoc[i] + " " );
		}
		System.out.println();
		return fruitLoc;
	}

	static int fruitCatcher( int fruit[], int start, int end ) {
		int fruitCaught = 0;
		for ( int i = 0; i < fruit.length; i++ ) {
			if ( fruit[i] >= start && fruit[i] <= end )
				fruitCaught++;
		}
		return fruitCaught;
	}
}
