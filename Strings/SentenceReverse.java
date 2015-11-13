// Pramp
// TODO try it with space

// Reverse all letters, then reverse each word
// Time: O(n)
// Space: O(1)
public static void reverseWords(char[] words){
	// Reverse all letters
	for(int i=0; i<words.length/2; i++){
		char temp = words[i];
		words[i] = words[words.length-1-i];
		words[words.length-1-i] = temp;
	}
	for(int i=0; i<words.length; i++){
		int space = i;
		// Find space
		for(;space<words.length; space++){
			if(words[space] == ' ') break;
		}
		// Reverse i until space
		for(int s=i, e=space-1;s < e; s++, e--){
			char temp = words[s];
			words[s] = words[e];
			words[e] = temp;
		}
		// Move i forward to start of next word
		i = space;
		while(i < words.length && words[i] != ' '){
			i++;
		}
	}
}


public static void reverseWords(char[] words){
	// Reverse all characters
	mirrorReverse(words, 0, words.length-1);

	// Reverse characters of each word
	for(int i=0; i<words.length; i++){
		if(words[i] == )
	}

}

public static void mirrorReverse(char[] words, int start, int end){
	while(start < end){
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		start++; end--;
	}
}