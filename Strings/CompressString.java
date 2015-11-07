/* CTCI
 * String compression using counts of repeated characters. (upper/lowercase characters a-z)
 * If the compressed string is not shorter, than return original string
 * Example:
 * "aabcccccaaa" -> "a2b1c5a3"
 */

public static String compress(String string){
	if(string == null || string.length() == 0)
		return string; 
	StringBuilder sb = new StringBuilder();
	int count = 0;

	for(int i=0; i<string.length(); i++){
		char c = string.charAt(i);
		count++;
		if(i+1 == string.length() || c != string.charAt(i+1)){
			sb.append(c).append(count);
			count = 0;
			if(sb.length() > string.length())
			    return string;
		}
	}

	return sb.toString();
}