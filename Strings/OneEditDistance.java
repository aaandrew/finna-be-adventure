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

public boolean oneEditDistance(String a, String b){
	int diff = Math.abs(a.length()-b.length());
	if(diff > 1){
		return false;
	}else if(diff == 1){
		return checkInsert(a, b);
	}else{
		return checkReplace(a, b);
	}
}

private boolean checkInsert(String a, String b){
	int length = Math.min(a.length(), b.length());
	int diff = 0;
	int i = 0, j = 0;
	while(i<a.length() && j<b.length()){
		if(a.charAt(i) != b.charAt(i)){
			diff++;
			if(diff > 1) return false;
			else if(a.length() > b.length()){
				i++;
			}else{
				j++;
			}
		}else{
			i++; j++;
		}
	}
	return true;
}

private boolean checkReplace(String a, String b){
	int diff = 0;
	for(int i=0; i<a.length(); i++){
		if(a.charAt(i) != b.charAt(i)){
			diff++;
			if(diff > 1) return false;
		}
	}
	return true;
}