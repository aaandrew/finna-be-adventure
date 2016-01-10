/* Leetcode
 * Implement strStr()
 * Returns the index of the first occurence of needle in haystack, 
 * or -1 if needle is not part of haystack
 */

public int strStr(String needle, String haystack){
	if(needle == null || haystack == null || needle.length() > haystack.length()) return -1;
	if(needle.length() == 0) return 0;

	for(int i=0; i<haystack.length(); i++){
		int j = 0;
		for(; j<needle.length(); j++){
			if(i+j >= haystack.length()){
				return -1;
			}else if(needle.charAt(j) != haystack.charAt(i+j)){
				break;
			}
		}
		if(j == needle.length()) return i;
	}
	return -1;
}