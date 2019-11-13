package time_problems;
/**
 * Convert the 12-Hour time to 24-Hour time format
		// INPUT_TIME -> OUTPUT_TIME
		// 06:40:03AM -> 06:40:03
		// 12:40:22AM -> 00:40:22 -- 00 String format case
		// 07:05:45PM -> 19:05:45 -- v.easy test case
		// 12:45:54PM -> 12:45:54 -- PM Scenario
		// 04:59:59AM -> 04:59:59 -- AM Scenario

 * @author Aniket.Bharsakale
 */
public class TimeConversion {

	private static final String COLON_DELIMITER = ":";
	private static final String EMPTY_STRING = "";
	private static final String AM = "AM";
	private static final String PM = "PM";

	public static void main(String[] args) {

		System.out.println("Converted 24-Hour Time: " + timeConversion("04:59:59AM"));

	}

	static String timeConversion(String targetTime) {
		System.out.println("Given 12-Hour Time: " + targetTime);
		String convertedString = EMPTY_STRING;
		String timeElements[] = new String[3];
		if (targetTime.contains(AM)) {
			timeElements = targetTime.replace(AM, EMPTY_STRING).split(COLON_DELIMITER);
			if (Integer.parseInt(timeElements[0]) < 12)
				convertedString = String.format("%02d", Integer.parseInt(timeElements[0])) + COLON_DELIMITER
						+ timeElements[1] + COLON_DELIMITER + timeElements[2];
			else
				convertedString = String.format("%02d", Math.abs(Integer.parseInt(timeElements[0]) - 12))
						+ COLON_DELIMITER + timeElements[1] + COLON_DELIMITER + timeElements[2];
		} else {
			timeElements = targetTime.replace(PM, EMPTY_STRING).split(COLON_DELIMITER);

			int hhTime = 12 + Integer.parseInt(timeElements[0]);
			if (hhTime >= 24 && Integer.parseInt(timeElements[1]) > 0)
				convertedString = EMPTY_STRING + 12 + COLON_DELIMITER + timeElements[1] + COLON_DELIMITER
						+ timeElements[2];
			else
				convertedString = EMPTY_STRING + (12 + Integer.parseInt(timeElements[0])) + COLON_DELIMITER
						+ timeElements[1] + COLON_DELIMITER + timeElements[2];
		}
		return convertedString;
	}
}
