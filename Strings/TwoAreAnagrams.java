/* Determin if two strings are anagrams
 * Ex:
 * 	anagrams("abc", "cba") -> true
 *	anagrams("abcd", "abc") -> false
 */

// Time: O(n)
// Space: O(1) - ascii,  O(n) - any character
public static boolean anagrams(String a, String b){
	int[] map = new int[256];
	for(int i=0; i<a.length(); i++){
		map[a.charAt(i)]++;
	}
	for(int i=0; i<b.length(); i++){
		map[b.charAt(i)]--;
		if(map[b.charAt(i)] < 0) return false;
	}
	return true;
}

// Time: O(nlogn)
// Space: O(n) or O(1) - if params char[]
public boolean anagrams(String a, String b){
	if(a.length() != b.length())
		return false;
	
	char[] aList = a.toCharArray();
	char[] bList = b.toCharArray();
	Arrays.sort(aList);
	Arrays.sort(bList);

	for(int i=0; i<aList.length; i++){
		if(aList[i] != bList[i])
			return false;
	}
	return true;
}