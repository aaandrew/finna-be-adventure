
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