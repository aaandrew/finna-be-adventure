/* CTCI, Leetcode
 * Given two strings, determine if they are one edit distance away.
 * Insert, remove, or replace a character
 *
 * Example:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */

public static boolean oneEditDistance(String a, String b){
	if(a.length() < b.length()) return oneEditDistance(b, a);
	int diff = Math.abs(a.length() - b.length());
	if(diff > 1) return false;
	int length = Math.min(a.length(), b.length());
	boolean oneReplace = false;

	for(int i=0, j=0; i<length; i++,j++){
		if(a.charAt(i) != b.charAt(j)){
			if(diff == 0){
				if(oneReplace) return false;
				oneReplace = true;
			}else{
				return checkEquals(a, i+1, b, j);
			}
		}
	}
	return true;
}

private static boolean checkEquals(String a, int i, String b, int j){
	while(i < a.length() && j < b.length()){
		if(a.charAt(i++) != b.charAt(j++)) return false;
	}
	return true;
}