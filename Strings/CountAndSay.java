/* Leetcode
 * The count-and-say sequence is the sequence is as follows
		1, 11, 21, 1211, 111221, ...
		1 is read off as "one 1" or 11.
		11 is read off as "two 1s" or 21.
		21 is read off as "one 2, then one 1" or 1211.
		
		Given an integer n, generate the nth sequence.
 */

// Time Complexity: O(n)
// Space Complexity: O(n)
public String countAndSay(int n){
	StringBuilder prev = new StringBuilder("1");
	StringBuilder next;
	for(int i=1; i<n; i++){
		next = new StringBuilder();
		int begin = 0, len = prev.length();
		for(int j=1; j<=len; j++){
			if(j == len || prev.charAt(j) != prev.charAt(begin)){
					// (j-begin) count, (begin) say
				next.append(j-begin).append(prev.charAt(begin));
				begin = j;
			}
		}
		prev = next;
	}
	return prev.toString();
}