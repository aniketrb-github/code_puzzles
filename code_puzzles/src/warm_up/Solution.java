package warm_up;

public class Solution {

    static int findDigits(int num) {
        int count = 0, digit = 0, temp = num;
        for(int i=0; i<=temp; i++) {            
            digit = temp % 10;  
            temp = temp / 10;   
            if(digit!=0 && num%digit==0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
            System.out.println(findDigits(12));
            System.out.println(findDigits(1012));
    }
}
