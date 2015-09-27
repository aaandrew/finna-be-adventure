/* Leetcode http://articles.leetcode.com/2010/04/finding-prime-numbers.html
 * Generate a prime number list from 0 to n (inclusive).
 */
public boolean[] primeSieve(int n){
	boolean[] sieve = new boolean[n+1];
	sieve[0] = false;
	sieve[1] = false;
	for(int i=2; i<=n; i++){
		prime[i] = true;
	}

	int limit = Math.sqrt(n);
	for(int i=2; i <= limit; i++){
		if(sieve[i]){
			for(int j=i*i; j<=n; j+=i){
				sieve[j] = false;
			}
		}
	}
	return sieve;
}