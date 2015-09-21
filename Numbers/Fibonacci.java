/*
 * Compute nth fibonacci
 */

// Recursion
// Time: O(2^n)
// Space: O(n)
public static long fib(int n){
	return n <= 1 ? n : fib(n-2) + fib(n-1);
}

// Dynamic Programming
// Time: O(n)
// Space: O(n)
public static long fib(int n){
	int[] d = [n+1];
	d[0] = 0;
	d[1] = 1;

	for(int i=2; i<=n; i++){
		d[i] = d[i-1] + d[i-2];
	}

	return d[n];
}

// Looping
// Time: O(n)
// Space: O(1)
public static long fib(int n){
	int prev = 0, cur = 1, next;

	if(n == 0) return prev;

	for(int i=2; i<=n; i++){
		next = prev + cur;
		prev = cur;
		cur = next;
	}
	return cur;
}