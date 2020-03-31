package warm_up;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Link: https://www.hackerrank.com/challenges/migratory-birds/problem
 * 
 * @author Aniket.Bharsakale
 */
public class MigratoryBirds {

    static void migratoryBirds(List<Integer> arr) {
		int count = 0, value = 0, maxValue = 0, maxKey = 0;
		Map<Integer, Integer> register = new HashMap<Integer, Integer>();
		Map<Integer, Integer> regFin = new HashMap<Integer, Integer>();
		regFin.put(0, 0);
		for (int i = 0; i < arr.size(); i++, count = 0, value = 0) {
			if (!register.containsKey(arr.get(i))) // first key occurrence
				register.put(arr.get(i), ++count);
			else
				continue;

			for (int j = i + 1; j < arr.size(); j++) {
				if (i <= j && arr.get(i) == arr.get(j) && register.containsKey(arr.get(i))) {
					value = register.get(arr.get(i)); // get existing value of key: arr(i)
					register.put(arr.get(i), ++value);
				}
			}
		}
       
        System.out.println("Gathered all Keys & their Values in a Map: ");
        printMap(register);
        // iterate the map & get the most common sightings
		for (Map.Entry<Integer, Integer> entry : register.entrySet()) {
			if (entry.getValue() > maxValue) {
				regFin.clear();
				maxValue = entry.getValue(); // update Key & Value with new max values found
				maxKey = entry.getKey();
				regFin.put(maxKey, maxValue);
			} else if (entry.getValue() >= maxValue) { // if same no. of sightings with diff typeID then insert new sighting
				maxKey = entry.getKey();
				regFin.put(entry.getKey(), entry.getValue());
			}
		}
        
        System.out.println("Filtered the Above Map by saving only most common bird sightings:");
        printMap(regFin);
		int minKey = maxKey; // assume minKey as the max key to start with
		// if sightings are even in more than 2, then pick the one with less idType
		for (Map.Entry<Integer, Integer> entry : regFin.entrySet()) {
			if (entry.getKey() < minKey)
				minKey = entry.getKey();
		}
		System.out.println("\nThe Final Bird Type Id: " + minKey);
    }

    /**
     * Starting point of this program
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3));
		//migratoryBirds(Arrays.asList(1, 2, 2, 4, 4, 3));
    	//migratoryBirds(Arrays.asList(1,2,4,4,4,4,4,4));
    	//migratoryBirds(Arrays.asList(1,2,3,4));
    	//migratoryBirds(Arrays.asList(1,2,2,4,4));
    }
    
    /** Function to print the given map
     * 
     * @param map
     */
    public static void printMap(Map<Integer, Integer> map) {
    	System.out.println();
    	for(Map.Entry<Integer, Integer> entry : map.entrySet())
        	System.out.println(entry.getKey()+"-"+entry.getValue());
    }
}
