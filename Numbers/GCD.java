
public class GCD {
	/*
	 * Find the GCD of p and q.
	 * GCD is the greatest common divisor that divides both p and q.
	 * 
	 * Solution:
	 * Euclid's Algorithm
	 * gcd(p,q) = gcd(q, p%q)
	 */
	
	// Recursive
	// Time: O(n)
	// Space: O(n)
	public static int greatestCommonDivisor(int p, int q){
		if(q == 0) return p;
		return greatestCommonDivisor(q, p%q);
	}
	
	// Iterative
	// Time: O(n)
	// Space: O(1)
	public static int greatestCommonDivisorIterative(int p, int q){
		while(q != 0){
			int temp = q;
			q = p%q;
			p = temp;
		}
		return p;
	}
	
	public static void main(String[] args){
		System.out.println(greatestCommonDivisorIterative(5, 8));
	}
}
