package date_problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Java program to find date after adding a given number of days. 
 *
 */
public class AddNumberOfDaysToDateString { 
	
// Find values of day and month from 
// offset of result year. 
static int m2, d2; 
public static Map<String, Integer> monthsMap = new LinkedHashMap<>();
	
// Return if year is leap year or not. 
static boolean isLeap(int y) 
{ 
	if (y % 100 != 0 && y % 4 == 0 || y % 400 == 0) 
		return true; 

	return false; 
} 

// Given a date, returns number of days elapsed 
// from the beginning of the current year (1st 
// jan). 
static int offsetDays(int d, int m, int y) 
{ 
	int offset = d; 

	if(m - 1 == 11) 
		offset += 335; 
	if(m - 1 == 10) 
		offset += 304; 
	if(m - 1 == 9) 
		offset += 273; 
	if(m - 1 == 8) 
		offset += 243; 
	if(m - 1 == 7) 
		offset += 212; 
	if(m - 1 == 6) 
		offset += 181; 
	if(m - 1 == 5) 
		offset += 151; 
	if(m - 1 == 4) 
		offset += 120; 
	if(m - 1 == 3) 
		offset += 90; 
	if(m - 1 == 2) 
		offset += 59; 
	if(m - 1 == 1) 
		offset += 31; 

	if (isLeap(y) && m > 2) 
		offset += 1; 

	return offset; 
} 

// Given a year and days elapsed in it, finds 
// date by storing results in d and m. 
static void revoffsetDays(int offset, int y) 
{ 
	int []month={ 0, 31, 28, 31, 30, 31, 30, 
					31, 31, 30, 31, 30, 31 }; 

	if (isLeap(y)) 
		month[2] = 29; 

	int i; 
	for (i = 1; i <= 12; i++) 
	{ 
		if (offset <= month[i]) 
			break; 
		offset = offset - month[i]; 
	} 

	d2 = offset; 
	m2 = i; 
} 

// Add x days to the given date. 
static void addDays(int d1, int m1, int y1, int x) 
{ 
	int offset1 = offsetDays(d1, m1, y1); 
	int remDays = isLeap(y1) ? (366 - offset1) : (365 - offset1); 

	// y2 is going to store result year and 
	// offset2 is going to store offset days 
	// in result year. 
	int y2, offset2 = 0; 
	if (x <= remDays) 
	{ 
		y2 = y1; 
		offset2 =offset1 + x; 
	} 

	else
	{ 
		// x may store thousands of days. 
		// We find correct year and offset 
		// in the year. 
		x -= remDays; 
		y2 = y1 + 1; 
		int y2days = isLeap(y2) ? 366 : 365; 
		while (x >= y2days) 
		{ 
			x -= y2days; 
			y2++; 
			y2days = isLeap(y2) ? 366 : 365; 
		} 
		offset2 = x; 
	} 
	revoffsetDays(offset2, y2); 
	System.out.println("d2 = " + d2 + ", m2 = " + 
							m2 + ", y2 = " + y2); 
} 

// Driven Program 
	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		//String inputDateString = in.next(); // 02-APR-2019
		//String arr [] = inputDateString.split("-");
		
		int d = 25, m = 12, y = 2019;
		int x = 366;
		/*
		if(isDayValid(Integer.parseInt(arr[0])) && isMonthValid(arr[1]) && isYearValid(Integer.parseInt(arr[2])) ) {
			
			addDays(Integer.parseInt(arr[0]), monthsMap.get(arr[1]).intValue(), Integer.parseInt(arr[2]), x);
		}*/
		
		addDays(d, m, y, x);
		//in.close();
	}
	
	public static boolean isMonthValid(String month) {
		if(monthsMap.containsKey(month.toUpperCase()))
			return true;
		else 
			return false;
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
	
	static {
		monthsMap.put("JAN", 1);
		monthsMap.put("FEB", 2);
		monthsMap.put("MAR", 3);
		monthsMap.put("APR", 4);
		monthsMap.put("MAY", 5);
		monthsMap.put("JUN", 6);
		monthsMap.put("JUL", 7);
		monthsMap.put("AUG", 8);
		monthsMap.put("SEP", 9);
		monthsMap.put("OCT", 10);
		monthsMap.put("NOV", 11);
		monthsMap.put("DEC", 12);
	}
} 

// This code is contributed by mits 
