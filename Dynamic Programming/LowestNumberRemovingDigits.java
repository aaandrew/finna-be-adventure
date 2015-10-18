/* http://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
 * Return the smallest number possible created by removing K number of digits from the input string S.
 *
 * Example:
 * S = “4205123” K = 4 
 * Answer is "012"
 *
 * Solution:
 * Think of problem as finding the smallest subsequence of size N-K
 * Find the smallest digit at index i, then the next smallest should be
 * found somewhere between [i+1, N-1] (inclusive)
 */

// Dyanmic Programming
// Time: O(n)
// Space: O(n)
// dp[i] = smallest index j > i such that S[i] > S[j].


// Wimpy solution
public static String lowestNumber(String num, int k){ 
	String result = num;
	int i = 0;
	for(i=0; i<k; i++){
		int index;
		for(index=0; index < num.length()-1; index++){
			if(result.charAt(index) > result.charAt(index+1)){
				result = result.substring(0, index) + result.substring(index+1, result.length());
				break;
			}
		}
		if(index == result.length()-1){
			result = result.substring(0, result.length()-1);
		}
	}
	return result;
}