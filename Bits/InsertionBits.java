/* CTCI
 * Given two 32-bit numbers N and M and two bit positions i and j
 * Insert M into N such that M starts at j and ends at i.
 * Assume i-j has enough space for M
 *
 * Example
 * Input:  N = 10000000000, M = 10011, i = 2, j = 6
 * output: N = 10001001100 
 */


// Note: i < j
public static int updateBits(int N, int M, int i, int j){
	// Clear bits of j-i in N
	// j+1 because of 0th index
	int left = (~0) << (j+1);
	int right = ((1 << i) - 1);
	int mask = left | right;
		
	// Shift M to line up with bits j through i
	M = M << i;
		
	// Merge M and N
	return (N & mask) | M;
}