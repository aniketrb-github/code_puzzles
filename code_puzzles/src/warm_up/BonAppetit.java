package warm_up;

import java.util.Arrays;
import java.util.List;

/**
* Link: https://www.hackerrank.com/challenges/bon-appetit/problem
* All Test cases passed!
* @author Aniket Bharsakale
*/
public class BonAppetit {

    static void bonAppetit(List<Integer> bill, int itemX, int chargedAmt) {
        int totalBillAmt = 0;
        int actualAmtPayable = 0;
        int refundAmt = 0;
        // itemX : Anna didn't eat | chargedAmt: amount charged
        for(int i=0; i<bill.size(); i++) {
            if(i == itemX)
                continue;
            else 
                totalBillAmt = totalBillAmt + bill.get(i);
        }
        
        actualAmtPayable = totalBillAmt / 2;

        /*System.out.println("Total Amt: "+totalBillAmt+"Item X Brei: "+itemX); 
        System.out.println("Actual Amt Payable: "+actualAmtPayable);
        System.out.println("Charged Amt: "+ chargedAmt);*/

        if(actualAmtPayable==chargedAmt)
            System.out.println("Bon Appetit"); 
        else if(chargedAmt>actualAmtPayable) {
            refundAmt = chargedAmt - actualAmtPayable;
            System.out.println(refundAmt); 
        }

    }

    public static void main(String[] args) {
        bonAppetit(Arrays.asList(3,10,2,9), 1, 12); // Expected Ans: RefundAmt: 5
		bonAppetit(Arrays.asList(3,10,2,9), 1, 7);	// Expected Ans: Bon Appetit
    }
}
