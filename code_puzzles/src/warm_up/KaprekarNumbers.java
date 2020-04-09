package warm_up;

import java.math.BigInteger;

/**
 * LinK: https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 * 
 * @author Aniket Bharsakale
 */
public class KaprekarNumbers {

	static void kaprekarNumbers(int lowerLimit, int upperLimit) {
		long chArrLength = 0;
		String strSqr = "", tempL = "", tempR = "";
		BigInteger nL = null, nR = null;
		char chArr[];
		boolean flag = false;
		for (int currNum = lowerLimit; currNum <= upperLimit; currNum++, tempL = "", tempR = "") {
			BigInteger currBNum = new BigInteger(String.valueOf(currNum));
			BigInteger squareNum = currBNum.multiply(currBNum);
			strSqr = String.valueOf(squareNum);
			chArr = strSqr.toCharArray();
			chArrLength = chArr.length;

			// Left & Right Digits extraction
			for (int i = 0; i < chArrLength - 1; i++) {
				tempL = tempL + chArr[i];

				for (int j = i + 1; j < chArrLength; j++)
					tempR = tempR + chArr[j];

				if (null != tempL && !tempL.isEmpty())
					nL = new BigInteger(tempL);

				if (null != tempR && !tempR.isEmpty() && Integer.parseInt(tempR) != 0)
					nR = new BigInteger(tempR);

				// Final check of Kaprekar's number criteria
				if (nL != null & nR != null && nL.add(nR).equals(currBNum) && !currBNum.equals(new BigInteger(String.valueOf(0)))) {
					System.out.print(currBNum + " ");
					flag = true;
					break;
				} else
					tempR = "";
			}
		}
		if(!flag)
			System.out.print("INVALID RANGE");
			
	}

	public static void main(String[] args) {
		kaprekarNumbers(400, 700); // 1-100: { 1 9 45 55 99 }
		// 400 & 700 : INVALID RANGE
		
		//checkNumber(2728); // 703, 2728, 857143 5292, 1 , 10 | Not work for: 2728 = {(2728 x 2728)= 7441984 | 744+1984 = 2728}
	}

	private static void checkNumber(int num) {
		long chArrLength = 0;
		BigInteger currBNum = new BigInteger(String.valueOf(num));
		BigInteger squareNum = currBNum.multiply(currBNum);
		String strSqr = "", tempL = "", tempR = "";
		char chArr[];
		BigInteger nL = null, nR = null;

		strSqr = String.valueOf(squareNum);
		chArr = strSqr.toCharArray();
		chArrLength = chArr.length;

		// Left & Right Digits extraction
		for (int i = 0; i < chArrLength - 1; i++) {
			tempL = tempL + chArr[i];

			for (int j = i + 1; j < chArrLength; j++)
				tempR = tempR + chArr[j];

			if (null != tempL && !tempL.isEmpty())
				nL = new BigInteger(tempL);

			if (null != tempR && !tempR.isEmpty() && Integer.parseInt(tempR) != 0)
				nR = new BigInteger(tempR);

			// Final check of Kaprekar's number criteria
			if (nL != null & nR != null && nL.add(nR).equals(currBNum) && !currBNum.equals(new BigInteger(String.valueOf(0)))) {
				System.out.print(num + " ");
				break;
			} else
				tempR = "";
		}
	}
	
	/* MY ACCEPTED ANSWER FOR ALL CASES TRUE AT HACKER RANK IS AS FOLLOWS: 
	
	
	static void kaprekarNumbers(int lowerLimit, int upperLimit) {
        long numLeft = 0, numRight = 0, chArrLength = 0;
        String strSqr = "", tempL = "", tempR = "";
        char chArr[];
        boolean flag = false;
        
        for (int currNum = lowerLimit; currNum <= upperLimit; currNum++, numLeft = 0, numRight = 0, tempL = "", tempR = "") {
            
            BigInteger currBNum = new BigInteger(String.valueOf(currNum));
            BigInteger squareNum = currBNum.multiply(currBNum);
            strSqr = String.valueOf(squareNum);
            chArr = strSqr.toCharArray();
            chArrLength = chArr.length;
            
            // Left & Right Digits extraction
            for (int count = 0; count < chArrLength; count++) {
                if (count < chArrLength / 2)
                    tempL = tempL + chArr[count];    
                else
                    tempR = tempR + chArr[count];
            }
            if (null != tempL && !tempL.isEmpty())
                numLeft = Integer.parseInt(tempL);
            if (null != tempR && !tempR.isEmpty())
                numRight = Integer.parseInt(tempR);

            // Final check of Kaprekar's number criteria
            if (numLeft + numRight == currNum && 0 != currNum) {
                System.out.print(currNum+" ");
                flag = true;
            }
        }
        if(!flag)
            System.out.print("INVALID RANGE");
    }
	
	*/
}
