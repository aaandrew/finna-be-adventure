/*
 * Determine if a number is prime. (
 * Natural number greater than 1, and only divisible by 1 and itself.
 */

// Brute force
// Time: O(n)
public boolean isPrime(int n){
	if(n < 2) return false;

	// Loop from 2 to n check divisible
	for(int i=2; i<n ;i++){
		if(n % i == 0)
			return false;
	}
	return true;
}

// Revised brute force
// Time: O(sqrt(n))
public boolean isPrime(int n){
	if(n < 2) return false;

	if(n == 2) return true;
  if(n % 2 == 0) return false;

	// Loop from 2 to sqrt(n) on odd numbers
	// sqrt(n) is mid point of divisors (second half is contained in first)
	for(int i=3; i*i <= n; i+=2){
		if(n % i == 0) 
			return false;
	}
	return true;
}

// Recursion
// Time: O(sqrt(n))
// Space: O(sqrt(n))
public boolean isPrime(int n) {
 if(n<2) {
  return false; 
	}
	return isPrime(n,2);
}

private boolean isPrime(int n, int i) {
	if(i*i > n) {
  	return true;
 	} 
 	if(n%i==0) {
 		return false;
 	}
 	return isPrime(n, i+1); 
}


// Test Cases
isPrime(5) == true
isPrime(0) == false
isPrime(1) == false
isPrime(-3) == false