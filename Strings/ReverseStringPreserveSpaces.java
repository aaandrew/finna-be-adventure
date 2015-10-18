/*
 * Reverse the string but preserve the position of spaces.
 * Example
 * " a if" => " f ia"
 */

public static String reverseStringPreserveSpace(String string){
	char[] chars = string.toCharArray();
	int start = 0, end = chars.length-1;
	while(start < end){
		if(chars[start] == ' '){
			start++;
		}else if(chars[end] == ' '){
			end--;
		}else{
			char temp = chars[start];
			chars[start++] = chars[end];
			chars[end--] = temp;
		}
	}
	return new String(chars);
}