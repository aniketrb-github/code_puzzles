package number_problems;

import java.util.ArrayList;
/**
 * Merge consecutive integer range of 3 or more into <first> - <last> format 
 * input = {-1, 5, 1, 2, 3, 8, 9, 11, 12, 13, 22, 23, 24}
 * output = [-1, 5, 1-3, 8, 9, 11-13, 22-24]
 * @author Aniket.Bharsakale
 */
public class MergeConsec3Numbers {

	public static void main(String[] args) {
		int arr[] = {-1, 5, 1, 2, 3, 8, 9, 11, 12, 13, 22, 23, 24};
		ArrayList<String> list = new ArrayList<>();
		int RANGE = 3;
		int curr = 0;
		int consec1 = 0;
		int consec2 = 0;
		int i = 0;
		int LENGTH = arr.length;
		for (; i < LENGTH; ) {
			
			curr = arr[i];
			consec1 = calcConsec(curr);
			
			if (i + 1 < LENGTH && arr[i + 1] == consec1) {
				consec2 = calcConsec(consec1);
				
				if (i + 2 < LENGTH && arr[i + 2] == consec2) {
					list.add(curr+"-"+consec2);
					i = i + RANGE;
				} else {
					list.add(arr[i]+"");
					i++;
				}
			} else {
				list.add(arr[i]+"");
				i++;
			}
		}
		System.out.println(list);
		
	}

	public static int calcConsec(int num) {
		return num + 1;
	}
}
