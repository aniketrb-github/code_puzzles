package number_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
HackerLand University has the following grading policy:

- Every student receives a grade in the inclusive range from 0 to 100.
- Any grade less 40 than is a failing grade.

Sam is a professor at the university and likes to round each student's grade according to these rules:
- If the difference between the grade and the next multiple of 5 is less than 3, round the grade up to the
next multiple of 5
- If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
For example, grade = 84 will be rounded to 85 but grade = 29 will not be rounded because the
rounding would result in a number that is less than 40.

 Input : 73, 67, 38, 33
 Output: 75, 67, 40, 33

 * @author Aniket.Bharsakale
 */
public class GradingStudents {

	public static void main(String[] args) {
		gradingStudents(Arrays.asList(73, 67, 38, 33));
	}

	public static List<Integer> gradingStudents(List<Integer> grades) {
		Integer diff = 0, roundUp = 0, quotient = 0;
		List<Integer> resultGrades = new ArrayList<Integer>();
		for (Integer grade : grades) {
			diff = grade % 5;
			if (grade >= 38 && diff >= 3) {
				// round up the grade to next multiple of 5
				quotient = grade / 5;
				roundUp = (++quotient) * 5;
				resultGrades.add(roundUp);
			} else {
				// no round up
				resultGrades.add(grade);
			}
		}
		return resultGrades;
	}
}
