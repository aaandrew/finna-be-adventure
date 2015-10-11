/* Leetcode
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

  For example, given n = 3, a solution set is:
  "((()))", "(()())", "(())()", "()(())", "()()()"
 */

// DFS
// Time: O(2^n)
// Space: O(2^n)
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

// f(0)
// ""

// f(1)
// (f0)
// ()

// f(2)
// (f0)f1, (f1)f0
// ()() (())

// f(3)
// (f0)f2, (f(1))f(1), (f(2))f0
// ()()(),()(())   (())()  (()()),((()))

// f(4)
// (f0)f3, (f1)f2, (f2)f1, (f3)f0


// Dynamic Programming
public List<String> generateParenthesis(int n){
  List<List<String>> allLists = new ArrayList<List<String>>();
  allLists.add(Collections.singletonList(""));

  for(int i=1; i<=n; i++){
    List<String> newList = new ArrayList<String>();
    for(int j=0; j<i; j++){
      for(String curString : allLists.get(j)){
        for(String endString : allLists.get(i-j-1)){
          newList.add("(" + curString + ")" + endString);
        }
      }
    }
    allLists.add(newList);
  }
  return allLists.get(n);
}




