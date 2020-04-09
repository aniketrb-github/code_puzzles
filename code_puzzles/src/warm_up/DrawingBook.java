package warm_up;
/**
 * Link: https://www.hackerrank.com/challenges/drawing-book/problem
 * 8/10 Test cases passed!
 * @author Aniket Bharsakale
 */
public class DrawingBook {

	static int pageCount(int n, int p) {
		int mid = n / 2;
		int count = 0;
		int leftPage = 0, rightPage = 0;
		boolean flag = false;

		if (p < mid || p == mid) { // begin from page1(Left - Right)
			if (p == 1)
				return 0;

			for (int i = 1; i <= mid;) {
				leftPage = i + 1;
				rightPage = i + 2;
				
				if (p >= leftPage && p <= rightPage) {  // couple locker
					if (p == i + 1 || p == i + 2) {
						count = count + 1;
						break;
					}
				} else {
					count = count + 1; // As per book, we turned a single page
					i = i + 2; // As per for loop, We increment by 2
				}
			}
		} else if (p > mid) {// begin from last page(Right to Left
			if (p == n || p == n - 1)
				return 0;
			
			flag = (n % 2 == 0) ? true : false;
			
			for (int i = n; i >= mid;) {
				if (flag) {
					leftPage = i - 2;
					rightPage = i - 1;
					count = count + 1;
				} else {
					leftPage = i - 1;
					rightPage = i;
				}

				if (p >= leftPage && p <= rightPage) { // couple locker
					if (p == leftPage || p == rightPage) {
						//count = count + 1;
						break;
					}
				} else {
					count = count + 1; // As per book, we turned a single page
					i = i - 2; // As per for loop, We increment by 2
				}

			}
		}
		
		System.out.println("n=" + n + "\tp=" + p + "\tcount:" + count);
		return count;
	}

    public static void main(String[] args) {
		/*
		 * pageCount(6, 3); pageCount(10, 4); pageCount(20, 8);
		 */
    	
    	// pageCount(20, 14); 
    	//pageCount(5, 4);
    	//pageCount(7, 4); 	// Expected Ans: 1
      	//pageCount(6, 4); 	// Expected Ans: 1
    	
      	pageCount(83246, 78132); 	// Expected Ans: 2557 | Actual : 5113
    }
}