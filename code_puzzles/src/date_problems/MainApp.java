package date_problems;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

	public static Map<Integer, String> indexedMonths = new HashMap<>();
	public static Map<String, Integer> monthsMap = new HashMap<>();
	static int givenDay = 0;
	static int givenYear = 0;
	static String givenMonth = "";
	
	private final static int NON_LEAP_YEAR = 365;
	private final static int LEAP_YEAR = 366;
	
	public static void main(String[] args) {
		String someDate = "27-APR-2019";
		String resultantDate =  dateModifier(someDate, 5);
		System.out.println("After adding 5 days to the given date: "+someDate+" the date is: "+resultantDate);
	}
	
	public static String dateModifier(String date, int numberOfDaysToBeAdded) {
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
		System.out.println("Since current month is: "+givenMonth);
		
		int numOfDaysInGivenMonth = getNumOfDaysInGivenMonth(isGivenYearLeapYear);
		
		int yearIncrementor = 0;
		int monthIncrementor = 0;
		
		// adding the number to date
		
		// best-easy case
		int resDay = givenDay + numberOfDaysToBeAdded;
		int temp = 0;

		// if addedReultDay exceeds a months/years limit, calculate next date & month
		if (resDay > 28 || resDay > 29 || resDay > 30 || resDay > 31) {
			// month increments if noOfDays = 28 & date is 1st feb or above 
			// year increments if resultant is >= 365/36
			
			if (resDay % NON_LEAP_YEAR == 0 || resDay % LEAP_YEAR == 0) {
				if (resDay % NON_LEAP_YEAR == 0) {
					temp = resDay / NON_LEAP_YEAR;
				}
				if (resDay % LEAP_YEAR == 0) {
					temp = resDay / LEAP_YEAR;
				}
				yearIncrementor = yearIncrementor + temp;
			}
		} else {
			
		}
			
		
		
		
		return null;
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

}
