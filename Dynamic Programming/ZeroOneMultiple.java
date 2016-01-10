/*
 * An integer whose base-ten representation consists only of zero and one is called a "zero-one" (ie binary nubmers)
 * Given an integer N, find the string S that represents the smallest positive "zero-one" 
 * which is a multiple of N. (Every N has atleast one S)
 * 
 * Constraint:
 * 0 < N < 100,000
 * S should be a zero-one integer and there should be no leading zeroes
 *
 * Example:
 * N = 4 => 101
 * N = 7 => 1001
 * 
 * Resources:
 * http://stackoverflow.com/questions/28268786/how-to-solve-zero-one-multiple-coding-solution
 */

// TODO
// Add DP solution

// Note: These solutions fail for 99,999 (too large of a number)
// Brute force
// Increment through all multiples of number until it has
// all ones or zeroes
public static String zeroOne(int number){
	long multiplier = 1;
	while(true){
		long product = multiplier++ * number;
		long temp = product;
		while ( temp != 0 ) {
			long digit = temp % 10;
			if ( digit != 0 && digit != 1 ) {
				break;
			}
			temp /= 10;
		}
		if (temp == 0) {
			return String.valueOf(product);
		}
	}
}

// Improved brute force
// Zero one is only binary so check all binary numbers for divisibility
// (1,10,11,100,101, etc.)
public static String zeroOne(int number){
	int i = 1;
	while(true){
		// Convert to binary
		String n = Integer.toBinaryString(i);
		// Convert to int
		int divider = Integer.parseInt(n);
		// Check if number is divisible
		if(divider % number == 0) return String.valueOf(divider);
		i++;
	}
}