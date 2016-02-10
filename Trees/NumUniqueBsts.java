/* LeetCode
 * Given n number of nodes, return the number of ways to create a unique BST
 * Catalan Numbers
 */

/* Explanation: Catalan Numbers

n 0 => 0

n 1 => 1
1

// 
n 2 => 2
1 2
{}-1-{1} = 1 * 1 = 1
{1}-2-{} = 1 * 1 = 1

1
 2
 
 2
1

//
n 3 => 5
1 2 3

{} - 1 - {2} = 1 * 2  = 2
{1} - 2 - {1} = 1 * 1 = 1
{2} - 3 - {} = 2 * 1 = 2

1
 2
  3
  
 1
  3
 2

  2
1  3

  3
 2
1

  3
1
 2
//
n 4  => 14
1 2 3 4
{} - 1 - {3} = 1 * 5 = 5
{1} - 2 - {2} =  1 * 2 = 2
{2} - 3 - {1} =  2 * 1 = 2
{3} - 4 - {} =  5 * 1 = 5
*/

// Dynamics programming
// Time: O(n)
// Space: O(n)
public static int numBsts(int n) {
  if(n < 0) return 0; 
  int[] dp = new int[n+1];
  dp[0] = 1;
  dp[1] = 1;
  for(int i=2; i<=n; i++){
    int temp = 0;
    for(int j=0; j<i; j++){
      int left = dp[j];
      int right = dp[i-j-1];
      temp += left + right - 1;
    }
    dp[i] = temp;
  }
  return dp[n];
}

// Iterative
// Time: O(n)
// Space: O(1)
