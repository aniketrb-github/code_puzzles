package warm_up;

/**
 * Link: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 * 
 * @author Aniket.Bharsakale
 */
public class CloudJumper {

    // Successful Solution for all 0 to 6 test cases.
    static int jumpingOnClouds(int[] c) {
        int j = 0;
        int i = 0;
        while(i < c.length) {
             if(i+2 < c.length && c[i+2] == 0) {
                 j++;
                 i = i+2;
             } else if(i+1 < c.length && c[i+1] == 0) {
                 j++;
                 i = i+1;
             } else { 
                 i++;             
             }
        }
        return j;
    }
}
