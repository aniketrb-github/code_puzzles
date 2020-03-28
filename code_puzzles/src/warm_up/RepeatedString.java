package warm_up;

/**
 * Link: https://www.hackerrank.com/challenges/repeated-string/problem
 * 
 * @author Aniket.Bharsakale
 */
public class RepeatedString {
    
	static long repeatedString(String s, long n) {
		StringBuilder sb = new StringBuilder(s);
		char[] chArr = s.toCharArray();

		while (sb.length() < n) {
			for (Integer i = 0; i < chArr.length; i++)
				if (sb.length() < n)
					sb.append(chArr[i]);
				else
					break;
		}

		char[] c = sb.toString().toCharArray();
		long count = 0;
		int k = 0;
		while (k < c.length) {
			if (c[k] == 'a') {
				count++;
			}
			k++;
		}
		return count;

		// return sb.toString();
	}
    
    private static final String str = "abaca";
    
    public static void main(String a[]) {
    	System.out.println(repeatedString(str, 10L));
    }
    
	public static Character[] toCharacterArray(String s) {
		if (null == s) {
			return null;
		}
		Character[] array = new Character[s.length()];
		for (int i = 0; i < s.length(); i++) {
			array[i] = s.charAt(i);
		}
		return array;
	}
        
}
