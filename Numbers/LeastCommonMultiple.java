
public class LeastCommonMultiple {

	/**
	 * Find the LCM, the smallest positive integer that has
	 * both p,q as factors.
	 * 
	 * ex. lcm(12,18) = 36 because 12*3 = 36 and 18*2 = 36.
	 */
	
	
	// Using GCD
	// lcm(p,q) = (p*q)/gcd(p,q)
	// Time: O(n) for gcd
	public static int lcm(int p, int q) throws ArithmeticException{
		return Math.abs(p*q)/gcd(p,q);
	}
	
	
	private static int gcd(int p, int q){
		while(q != 0){
			int temp = q;
			q = p%q;
			p = temp;
		}
		return p;
	}
	public static void main(String[] args){
		System.out.println(lcm(-1,-20));
	}
}
