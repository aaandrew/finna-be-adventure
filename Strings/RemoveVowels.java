/* Remove vowels from string
 * Ex. removeVowels("racecar") -> "rccr"
 */

// Time: O(n)
// Space: O(n)
public static String removeVowels(String s){
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<s.length(); i++){
		if(!isVowel(s.charAt(i)))
			sb.append(s.charAt(i));
	}
	return sb.toString();
}

public static boolean isVowel(char c){
	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
		return true;
	return false;
}