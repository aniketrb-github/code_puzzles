package list_iteration_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("B");
		list.add("C");
		list.add("D");
		
		removeDuplicatesUsingList(list);
		removeDuplicatesUsingSet(list);
		removeDuplicatesUsingLambda(list);
	}
	
	/**
	 * Using list, we filter duplicate tokens from the given list & return a new list containing unique items
	 * @param listWithDuplicates
	 * @return
	 */
	public static void removeDuplicatesUsingList(ArrayList<String> listWithDuplicates) {
		List<String> uniqueList = new ArrayList<>();
		
		for (String token : listWithDuplicates) {
			if (!uniqueList.contains(token)) {
				uniqueList.add(token);
			}
		}
		printList(uniqueList, ": Using List Collection");
	}
	
	/**
	 * Using Set collection we remove the duplicates from the given list
	 * @param listWithDuplicates
	 * @return
	 */
	public static void removeDuplicatesUsingSet(ArrayList<String> listWithDuplicates) {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.addAll(listWithDuplicates);
		List<String> uniqueList = new ArrayList<String>(hashSet);
		printList(uniqueList, ": Using Set Collection");
	}
	
	/**
	 * Using a simple lambda expression we return back the unique list
	 * @param listWithDuplicates
	 * @return
	 */
	public static void removeDuplicatesUsingLambda(ArrayList<String> listWithDuplicates) {
		List<String> list = listWithDuplicates.stream().distinct().collect(Collectors.toList());
		printList(list, ": Using Lambda Expression");
	}
	
	
	public static void printList(List<String> list, String methodUsed) {
		System.out.println("Removed Duplicates from List "+methodUsed);
		list.forEach((e) -> System.out.print(e+" "));
		System.out.println();
	}

}
