/* Leetcode
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

  For example, given n = 3, a solution set is:
  "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public List<String> generateParenthesis(int n) {
  List<String> list = new ArrayList<String>();
  backtrack(list, "", n, 0);
  return list;
}

public void backtrack(List<String> list, String string, int left, int right){
  if(left == 0 && right == 0){
    list.add(string);
  }else{
    if(right > 0)
      backtrack(list, string + ")", left, right-1);
    if(left > 0)
      backtrack(list, string + "(", left-1, right+1);
    }
  }