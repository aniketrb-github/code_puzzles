package number_problems;
/**
 * Find the total count of the tallest candles planted on u birthday cake.
 * For Ex.1: there are 4 candles of height:3 2 1 3 planted on ur cakes
 * then totalTallestCandleCount = 2 since 3 is the tallest candle of all
 * & there are 2 such candles.
 *  
Ex.2: there are n = 10 candles on a cake
candlesOnTheCake = {18 90 90 13 90 75 90 8 90 43}
output = 5 (90 is found 5 times)
 * @author Aniket.Bharsakale
 */
public class TallestCandles {

	public static void main(String[] args) {
		int candlesOnTheCake[] = { 18, 90, 90, 13, 90, 75, 90, 8, 90, 43 };
		System.out.println("Total number of tallest candles are: " + birthdayCakeCandles(candlesOnTheCake));
	}

	static int birthdayCakeCandles(int[] candlesOnTheCake) {
		int maxHeight = candlesOnTheCake[0], tallestCandleCount = 0;
		// First find the tallest candle planted on the birthday cake
		for (int count = 0; count < candlesOnTheCake.length; count++) {
			if (candlesOnTheCake[count] > maxHeight) {
				maxHeight = candlesOnTheCake[count];
			}
		}
		// Find the count of the number of the tallest candles on the cake
		for (int count = 0; count < candlesOnTheCake.length; count++) {
			if (candlesOnTheCake[count] >= maxHeight) {
				tallestCandleCount++;
			}
		}
		return tallestCandleCount;
	}
}
