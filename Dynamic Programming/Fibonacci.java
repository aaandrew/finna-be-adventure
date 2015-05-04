/* Return the nth fibonacci number
 *
 */

// Time: O(n)
// Space: O(1)
public int fib3(int n) {
  if (n <= 1) {
    return 1;
  }
  int prev = 1;
  int prevprev = 1;
  int res = 2;
  for (int j = 1; j < n; j++) {
    res = prev + prevprev;
    prevprev = prev;
    prev = res;
  }
  return res;
}

// Time: O(n)
// Space: O(n)
public int fib2(int n) {
  int[] vals = new int[n+1];
  for (int i = 0; i <= n; i++) {
    if (i == 0 || i == 1) {
      vals[i] = 1;
    } else {
      vals[i] = vals[i-1] + vals[i-2];
    }
  }
  return vals[n];
}

// Time: O(2^n)
// Sapce: O(2^n)
public int fib1(int n) {
  if (n <= 1) {
    return 1;
  }
  return fib1(n - 1) + fib1(n - 2);
}