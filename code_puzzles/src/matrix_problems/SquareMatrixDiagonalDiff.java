package matrix_problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given a square matrix, calculate the absolute difference between the sums of
 * its diagonals. For example, the square matrix (3x3) "arr" is shown below: where n=3
 * 1 2 3 
 * 4 5 6 
 * 9 8 9 
 * Primary Diagonal		(P) = 1+5+9 = 15 
 * Secondary Diagonal	(S) = 3+5+9 = 17
 * Absolute Difference of the given Square matrix = |P - S| -> |15-17| = |-2| = 2
 * 
 * @author Aniket.Bharsakale
 */
class Result {

	/*
	 * Given a square matrix, calculate the absolute difference between the sums of
	 * its diagonals. For example, the square matrix "arr" is shown below: 1 2 3 4 5
	 * 6 9 8 9 Primary Diagonal : P = 1+5+9 = 15 Secondary Diagonal:S = 3+5+9 = 17
	 * Absoulte Difference |P - S| -> |15-17| = |-2| = 2
	 */

	public static int diagonalDifference(List<List<Integer>> arr) {
		Integer d1 = calculateDiagonalSum(arr, true);
		Integer d2 = calculateDiagonalSum(arr, false);
		System.out.println("Primary Diagonal : " + d1 + "\nSecondary Diagonal: " + d2);
		return Math.abs(d1 - d2);
	}

	public static int calculateDiagonalSum(List<List<Integer>> arr, boolean flag) {
		int i = 999, j = 999;
		Integer d1Sum = 0;
		Integer d2Sum = 0;

		for (i = 0; i < arr.size(); i++) {
			List<Integer> temp = arr.get(i);
			if (true == flag) {
				for (j = 0; j <= i; j++) {
					if (i == j)
						d1Sum = d1Sum + temp.get(j);
				}
			} else {
				for (j = 0; j <= arr.size() - 1; j++) {
					if ((i + j) == arr.size() - 1) {
						d2Sum = d2Sum + temp.get(j);
					}
				}
			}
		}

		if (true == flag)
			return d1Sum;
		else
			return d2Sum;
	}

}

public class SquareMatrixDiagonalDiff {
	public static void main(String[] args) throws IOException {
		int rowsAndCols = 3;	// Number of Rows & Columns in the Square Matrix
		List<List<Integer>> arr = new ArrayList<>();
		Random random = new Random();	// Just to generate Random numbers in the Matrix

		for (int i = 0; i < rowsAndCols; i++) {

			List<Integer> arrRowItems = new ArrayList<>();

			for (int j = 0; j < rowsAndCols; j++) {
				arrRowItems.add(random.nextInt(10));	// 10 is for having numbers below 10 in our Square Matrix
			}
			System.out.println(arrRowItems);
			arr.add(arrRowItems);
		}

		System.out.println("Absolute difference of Primary & Secondary Diagonal = " + Result.diagonalDifference(arr));

	}
}
