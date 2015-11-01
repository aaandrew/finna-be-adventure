
// Time: O(n!)
// Space: O(n!)
public static void permutation(char[] string, int start){
	if(start >= string.length)
		System.out.println(string);
	else{
		for(int i=start; i<string.length; i++){
			swap(string, i, start);
			permutation(string, start+1);
			swap(string, i, start);
		}
	}
}

private static void swap(char[] string, int i, int j){
	char c = string[i];
	string[i] = string[j];
	string[j] = c;
}

// Time: O(n!)
// Space: O(n!)
public static void permutation(String string){
	permutation(string, "");
}

public static void permutation (String remainder, String prefix){
	if(remainder.length() == 0){
		System.out.println(prefix);
	}else{
		for(int i=0; i<remainder.length(); i++){
			String rem = remainder.substring(0, i) + remainder.substring(i+1);
			permutation(rem, prefix + remainder.charAt(i));
		}
	}
}