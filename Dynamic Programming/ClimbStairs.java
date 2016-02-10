/* CTCI, Leetcode
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */

// 2 Ways
public int climbStairs(int n) {
  int[] dp = new int[n+1];
  dp[0] = 1; dp[1] = 1;
  for(int i=2; i<=n; i++){
    dp[i] = dp[i-1] + dp[i-2];
  }
  return dp[n];
}
// 3 Ways
// dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
public static int climbStairs(int n){
  if(n <= 0) return 0;
  int[] dp = new int[n+1];
  dp[0] = 1; dp[1] = 1; dp[2] = 2;
  for(int i=3; i<=n; i++){
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
  }
  return dp[n];
}

public static int climbStairs(int n){
  if(n <= 0) return 0;
  int n1 = 1;
  int n2 = 1;
  int n3 = 2;
  for(int i=3; i<=n; i++){
    int temp = n3;
    n3 = n3 + n2 + n1;
    n1 = n2;
    n2 = temp;
  }
  return n3;
}

public static void main(String[] args){
  System.out.println(climbStairs(10));
  System.out.println(climbStairs(9));
  System.out.println(climbStairs(8));
  System.out.println(climbStairs(7));
  System.out.println(climbStairs(6));
  System.out.println(climbStairs(5));
}