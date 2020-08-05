package easy_problems;

/**
 * Link: hackerrank.com/challenges/strange-advertising/problem All 5 test cases
 * passed!
 * 
 * @author Aniket Bharsakale
 */
public class StrangeAdvertising {

	static int viralAdvertising(int nthDay) {
		int advtShare = 5, totalPrevLikes = 0, newPplLikes = 0;

		for (int i = 0; i < nthDay; i++) {
			newPplLikes = advtShare / 2; // total ppl. liked the advt.
			advtShare = newPplLikes * 3; // total ppl. shared the advt
			totalPrevLikes = totalPrevLikes + newPplLikes;
		}
		return totalPrevLikes;
	}

	public static void main(String[] args) {
		// For 3rd day the total/cumulative likes = 9
		System.out.println("For 3rd day the total/cumulative likes = "+viralAdvertising(3));
		
		// For 5th day the total/cumulative likes = 24
		System.out.println("For 5th day the total/cumulative likes = "+viralAdvertising(5)); 
	}
}
