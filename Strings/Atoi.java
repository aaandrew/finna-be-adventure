/* Leetcode
 * Implement atoi to convert a string to an integer
 */

public int myAtoi(String str) {
  if(str == null || str.length() == 0){
    return 0;
  }
  // Trim whitespace
  str = str.trim();
  // Check if sign of int
  char firstChar = str.charAt(0);
  boolean isNegative = false;
  int start = 0, result = 0;
  if(firstChar == '-'){
    isNegative = true;
    start++;
  }else if(firstChar == '+')
  start++;

  int overflowCheck = Integer.MAX_VALUE / 10;        
  for(int i=start; i<str.length(); i++){
    char c = str.charAt(i);
    int currentResult = result;
    if(c < '0' || c > '9') break;
    // Check overflow
    if(result > overflowCheck || result == overflowCheck &&  c > '7'){
      if(isNegative) return Integer.MIN_VALUE;
      return Integer.MAX_VALUE;
    }
    result = result*10 + c - '0';
  }

  if(isNegative)
    return -result;

  return result;
}