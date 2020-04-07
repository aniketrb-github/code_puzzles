import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://www.hackerrank.com/challenges/picking-numbers/problem
 * 
 * 9/10 Test cases passed!
 * @author Aniket Bharsakale
 */
public class PickingNumbers {

	public static int pickingNumbers(List<Integer> arr) {
		List<List<Integer>> parentHolder = new ArrayList<List<Integer>>();
		List<Integer> tempList;
		int diff = 0;

		// alike numbers group maker
		for (int i = 0; i < arr.size(); i++) {
			tempList = new ArrayList<Integer>();
			tempList.add(arr.get(i));

			for (int j = 0; j < arr.size(); j++) {
				if (i != j) {
					diff = Math.abs(arr.get(i) - arr.get(j));
					if (diff <= 1)
						tempList.add(arr.get(j));
				}
			}
			parentHolder.add(tempList);
		}
		parentHolder = rottenElementRemover(parentHolder, true);
		parentHolder = rottenElementRemover(parentHolder, false);
		printList(parentHolder);
		return getMaxSize(parentHolder);
	}
	
	/**
	 * To return the max length of the largest list in parentList
	 * @param parentHolder
	 * @return max length
	 */
	public static int getMaxSize(List<List<Integer>> parentHolder) {
		int maxSize = 0;
		for (List<Integer> list : parentHolder) {
			if (list.size() > maxSize)
				maxSize = list.size();
		}
		return maxSize;
	}

	public static List<List<Integer>> rottenElementRemover(List<List<Integer>> parentHolder, boolean bound) {
		int diff = 0, negCnt = 0;
		List<Integer> tempList;

		for (int k = 0; k < parentHolder.size(); k++, diff = 0) {
			tempList = parentHolder.get(k);
			for (int i = 0; i < tempList.size(); i++, negCnt = 0) {
				for (int j = 0; j < tempList.size(); j++) {
					if (i != j) {
						diff = Math.abs(tempList.get(i) - tempList.get(j));
						if (diff > 1)
							negCnt++; // rotten element spotter
					}
				}
				// rotten element remover
				if (bound) {
					if (negCnt >= tempList.size() / 2)
						tempList.remove(i);
				} else {
					if (negCnt >= 1)
						tempList.remove(i);
				}
			}
		}
		return parentHolder;
	}

	private static void printList(List<List<Integer>> parentHolder) {
		System.out.println();
		for(List<Integer> list : parentHolder) {
			System.out.println(list);
		}
	}

	public static void main(String[] args) {

		// System.out.println(pickingNumbers(Arrays.asList(2, 4, 6, 5, 3, 3, 1))); // Expected Ans: 3
		//System.out.println(pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2))); // Expected Ans: 5
		// System.out.println(pickingNumbers(Arrays.asList(4, 2 ,3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4, 98, 2, 98, 3, 9, 9, 3, 1, 4, 1, 98, 9, 9, 2, 9, 4, 2, 2, 9, 98, 4, 98, 1, 3, 4, 9, 1, 98, 98, 4, 2, 3, 98, 98, 1, 99, 9, 98, 98, 3, 98, 98, 4, 98, 2, 98, 4, 2, 1, 1, 9, 2, 4))); // Asn: 22
		
		/*
		System.out.println(
		  pickingNumbers(
		  Arrays.asList(84,43,11,41,2,99,31,32,56,53,42,14,98,27,64,57,16,33,48,21,46,
		  61,87,90,28,12,62,49,29,77,82,70,80,89,95,52,13,19,9,79,35,67,51,39,7,1,66,8,
		  17,85,71,97,34,73,75,6,91,40,96,65,37,74,20,68,23,47,76,55,24,3,30,22,55,5,69
		  ,86,54,50,10,59,15,4,36,38,83,60,72,63,78,58,88,93,45,18,94,44,92,81,25,26)
		  )); // Expected Ans: 3
		*/
		
		// failure test case
		System.out.println(
				  pickingNumbers(
						  Arrays.asList(14, 18, 17, 10, 9, 20, 4, 13, 19, 19, 8, 15, 15, 17, 6, 5, 15, 12, 18, 2, 18, 7, 20, 8, 2, 8, 11, 2, 16, 2, 12, 9, 3, 6, 9, 9, 13, 7, 4, 6, 19, 7, 2, 4, 3, 4, 14, 3, 4, 9, 17, 9, 4, 20, 10, 16, 12, 1, 16, 4, 15, 15, 9, 13, 6, 3, 8, 4, 7, 14, 16, 18, 20, 11, 20, 14, 20, 12, 15, 4, 5, 10, 10, 20, 11, 18, 5, 20, 13, 4, 18, 1, 14, 3, 20, 19, 14, 2, 5, 13)
						  ));
	}
}
