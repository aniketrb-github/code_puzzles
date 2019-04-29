package date_problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainApp {

	public static Map<Integer, String> indexedMonths = new LinkedHashMap<>();
	public static Map<String, Integer> monthsMap = new LinkedHashMap<>();
	static Integer givenDay = 0;
	static Integer givenYear = 0;
	static String givenMonth = "";
	
	private final static Integer NON_LEAP_YEAR = 365;
	private final static Integer LEAP_YEAR = 366;
	
	public static void main(String[] args) {
		String someDate = "27-OCT-2023";
		Integer daysToBeAdded = 6;
		
		// System.out.println("---"+calculateDaysOfNextMonth("JAN", true) );

		String resultantDate = dateModifier(someDate, daysToBeAdded);
		System.out.println("After adding " + daysToBeAdded + " days to given date: " + someDate + " the date is: "
				+ resultantDate);
 
	}
	
	public static String dateModifier(String date, int numberOfDaysToBeAdded) {
		String finalDay = "";
		String finalMonth = "";
		String finalYear = "";
		
		String dateArray [] = date.split("-");
		
		if(isDayValid(Integer.parseInt(dateArray[0])) ) 
			givenDay = Integer.parseInt(dateArray[0]);
		else 
			return "Invalid Day of Month entered in Input.";
		
		if(isYearValid(Integer.parseInt(dateArray[2])) )
			givenYear = Integer.parseInt(dateArray[2]);
		else 
			return "Invalid Year! Year cannot be negative!";
		
		if(isMonthValid(dateArray[1])) 
			givenMonth = dateArray[1];
		else 
			return "Invalid Month! Such month does not exist.";
		
		boolean isGivenYearLeapYear = checkIfGivenYearIsLeapYear(Integer.parseInt(dateArray[2]));
		System.out.println("Input Date assumed for InputDate is "+date);
		
		int numOfDaysInGivenMonth = getNumOfDaysInGivenMonth(isGivenYearLeapYear);
		
		int yearIncrementor = 0;
		int monthIncrementor = 0;
		
		Entry<String, Integer> numOfDaysInNextMonth = null;
		// adding the number to date
		
		// best-easy case
		Integer resultDayOfMonth = givenDay + numberOfDaysToBeAdded;
		boolean init = true;
		// if addedReultDay exceeds a months/years limit, calculate next date & month
		if (resultDayOfMonth >= 28) {
 
			if (isGivenYearLeapYear) {
				if (resultDayOfMonth % LEAP_YEAR >= 0)
					yearIncrementor = resultDayOfMonth / LEAP_YEAR;
			} else {
				if (resultDayOfMonth % NON_LEAP_YEAR >= 0)
					yearIncrementor = resultDayOfMonth / NON_LEAP_YEAR;
				
				int temp = resultDayOfMonth;  
				while(resultDayOfMonth > 0) {
					if(init)
						numOfDaysInNextMonth = calculateDaysOfNextMonth(givenMonth, isGivenYearLeapYear);
					else {
						init = false;
						numOfDaysInNextMonth = calculateDaysOfNextMonth(numOfDaysInNextMonth.getKey(), isGivenYearLeapYear);
					}
					
					temp = resultDayOfMonth / numOfDaysInNextMonth.getValue();
					if(temp > 0) {
						temp += monthIncrementor;
					}
					
					resultDayOfMonth -= numOfDaysInNextMonth.getValue();
				}
			}
			
			finalYear += yearIncrementor;
			
			finalDay = resultDayOfMonth.toString();
			
		} else {
			// here date is lower than 28 so its within same month
			finalDay = resultDayOfMonth.toString();
			finalMonth = givenMonth;
			finalYear = givenYear.toString();
		}
			
		return finalDay+"-"+finalMonth+"-"+finalYear;
	}
	
	/**
	 * Calculates the number of days in the input given month
	 * @param isGivenYearLeapYear
	 * @return
	 */
	public static int getNumOfDaysInGivenMonth(boolean isGivenYearLeapYear) {
		int numOfDaysInGivenMonth = 0;
		// LEAP YEAR's FEB has 29 days
		if (isGivenYearLeapYear) {
			if (givenMonth.equals("FEB"))
				numOfDaysInGivenMonth = monthsMap.get(givenMonth) + 1;
			else
				numOfDaysInGivenMonth = monthsMap.get(givenMonth);
		} else {
			// NON-LEAP
			numOfDaysInGivenMonth = monthsMap.get(givenMonth);
		}
		return numOfDaysInGivenMonth;
	}
	
	/**
	 * Since every 4th year is a Leap year
	 * if a year is evenly divisible by 4, then its a Leap Year
	 * for ex. 2020 is Leap while 2019 is Non-Leap 
	 * @param year
	 * @return
	 */
	public static boolean checkIfGivenYearIsLeapYear(int year) {
		if(year % 4 == 0)
			return true;
		else 
			return false;
	}
	
	public static boolean isDateStringNullOrEmpty(String date) {
		if(null != date && !date.isEmpty())
			return false;
		else 
			return true;
	}
	
	// initially considered as Non-Leap Year, hence FEB is of 28 days
	static {
		monthsMap.put("JAN", 31);
		monthsMap.put("FEB", 28);
		monthsMap.put("MAR", 31);
		monthsMap.put("APR", 30);
		monthsMap.put("MAY", 31);
		monthsMap.put("JUN", 30);
		monthsMap.put("JUL", 31);
		monthsMap.put("AUG", 31);
		monthsMap.put("SEP", 30);
		monthsMap.put("OCT", 31);
		monthsMap.put("NOV", 30);
		monthsMap.put("DEC", 31);
	}
	
	// indexed months initialization
	static {
		indexedMonths.put(1, "JAN");	
		indexedMonths.put(2, "FEB");
		indexedMonths.put(3, "MAR");
		indexedMonths.put(4, "APR");
		indexedMonths.put(5, "MAY");
		indexedMonths.put(6, "JUN");
		indexedMonths.put(7, "JUL");
		indexedMonths.put(8, "AUG");
		indexedMonths.put(9, "SEP");
		indexedMonths.put(10, "OCT");
		indexedMonths.put(11, "NOV");
		indexedMonths.put(12, "DEC");
	}
	
	public static boolean isYearValid(int year) {
		if(year > 0) 
			return true;
		else 
			return false;
	}
	
	public static boolean isDayValid(int day) {
		if(day < 0)
			return false;
		else if(day > 31)
			return false;
		else 
			return true;
	}
	
	public static boolean isMonthValid(String month) {
		if(monthsMap.containsKey(month.toUpperCase()))
			return true;
		else 
			return false;
	}
	
	public static Entry<String, Integer> calculateDaysOfNextMonth(String givenMonth, boolean isGivenYearLeapYear) {
		boolean flag = false;
		Entry<String, Integer> resultEntry = null;

		if (monthsMap.containsKey(givenMonth)) {
			for (Entry<String, Integer> entry : monthsMap.entrySet()) {
				if (flag) {
					if (isGivenYearLeapYear) {
						if ("FEB".equalsIgnoreCase(entry.getKey())) {
							resultEntry = entry;
							resultEntry.setValue(resultEntry.getValue() + 1);
							break;
						}
					}
					resultEntry = entry;
					break;

				} else if (entry.getKey().equalsIgnoreCase(givenMonth))
					flag = true;
			}
		}
		return resultEntry;
	}
	
}
