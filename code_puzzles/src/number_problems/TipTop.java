package number_problems;

public class TipTop {
	static final Integer i1 = 1;
	final Integer i2 = 2;
	Integer i3 = 3;
	public static void main(String[] args) {
		/*final Integer i4 = 4;
		Integer i5 = 5;
		class Inner {
			final Integer i6 = 6;
			Integer i7 = 7;
			Inner() {
				System.out.println(i6 + i7);
			}
		}
		*/
		/*
		String str = " Hi this is interesting,  what do you say man, don't you think?";
		
		for(String s : str.split(",")) {System.out.println(s); }
		*/
		
		try {
			throw new Exc1();
		} catch (ABC e) {
			System.out.println("Exc0 caught");
		} catch (Exception e1) {
			System.out.println("Exception caught");
		}
		
	}
	
}

class ABC extends Exception {}
class Exc1 extends ABC {}

