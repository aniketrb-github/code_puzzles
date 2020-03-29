package warm_up;

/**
 * Link: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 * 
 * @author Aniket.Bharsakale
 */
public class BasketballScore {

	static void breakingRecords(int[] scores) {
        int minCount = 0, maxCount = 0, minScore = scores[0], maxScore = scores[0];
        for(int i=1; i<scores.length; i++) {
            if(scores[i] < minScore) {
                minScore = scores[i];
                minCount++;
            } else if(scores[i] > maxScore){
                maxScore = scores[i];
                maxCount++;
            } else 
                continue;
        }
        System.out.println("MaxCount: "+maxCount+"\tMinCount: "+minCount);
    }

    public static void main(String[] args) {
    	int scoresSeason1[] = {10, 5, 20, 20, 4, 5, 2, 25, 1};
    	int scoresSeason2[] = {9, 8, 10, 7, 14, 15, 19, 25, 26};
    	breakingRecords(scoresSeason2);
    }
}
