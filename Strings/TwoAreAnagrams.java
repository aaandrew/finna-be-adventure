/* Check if two strings are anagrams
 * Ex:
 * 	anagrams("abc", "cba") -> true
 *	anagrams("abcd", "abc") -> false
 */
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