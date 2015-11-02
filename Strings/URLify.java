/* CTCI
 * Replace all spaces in string with "%20". Assume string has sufficient space
 * to hold additional characters, and you are given length of string
 * Example
 * Input: "Mr John Smith    ", 13
 * Ouput: "Mr%20John%20Smith"
 */

public static void urlify(char[] chars, int length){
	if(chars == null) return;

	int ptr = length-1;
	int i = chars.length-1;

	while(i >=0){
		if(chars[ptr] != ' '){
			chars[i--] = chars[ptr--];
		}else{
			i = putPattern(chars, i, "%20");
			ptr--;
		}
	}
}

private static int putPattern(char[] chars, int i, String pattern){
	for(int j=pattern.length()-1; j>=0; j--){
		chars[i--] = pattern.charAt(j);
	}
	return i;
}