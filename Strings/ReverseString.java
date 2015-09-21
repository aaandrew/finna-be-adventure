/*
 * Reverse string
 */
public static String reverse(String s){
	char[] chars = s.toCharArray();

	int length = chars.length;

	for(int i=0; i<length/2; i++){
		char c = chars[i];
		chars[i] = chars[length - 1 - i];
		chars[length - 1 - i] = c;
	}
	return new String(chars);
}