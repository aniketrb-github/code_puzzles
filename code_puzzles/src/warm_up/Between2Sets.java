package warm_up;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Link: https://www.hackerrank.com/challenges/between-two-sets/problem
 * 
 * @author Aniket.Bharsakale
 */
public class Between2Sets {
	
	public static int getTotalX(List<Integer> listA, List<Integer> listB) {
		// LambdaExpression to get max number from a list: https://stackoverflow.com/questions/24378646/finding-max-with-lambda-expression-in-java
		int maxNumA = listA.stream().max(Comparator.comparing(i -> i)).get();
		int maxNumB = listB.stream().max(Comparator.comparing(i -> i)).get();
		int allMaxNum = (maxNumA > maxNumB) ? maxNumA : maxNumB;

		List<Integer> finalNos = new ArrayList<Integer>();
		boolean flagA, flagB;

		// For considered integer, all elements from listA must be factors of(divisible by) 'con'
		for (int con = 1; con <= allMaxNum; con++) {
			flagA = false;
			flagB = false;
			for (int num : listA) {
				if (con % num == 0) {
					flagA = true;
					continue;
				} else {
					flagA = false;
					break;
				}
			}

			if (flagA) {
				// For considered integer, 'con' must be a factor of(divisible by) all elements from listB
				for (int ele : listB) {
					if (ele % con != 0) {
						flagB = false;
						break;
					} else {
						flagB = true;
						continue;
					}
				}
				if (flagB)
					finalNos.add(con);
			}
		}
		return finalNos.size();
	}
	
	public static void main(String[] args) {
		// System.out.println(getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96)));	// Expected Answer: 3
		// System.out.println(getTotalX(Arrays.asList(2), Arrays.asList(20, 30, 12)));		// Expected Answer:: 1
		 System.out.println(getTotalX(Arrays.asList(3, 4), Arrays.asList(24, 48))); 		// Expected Answer:: 2
	}
}
