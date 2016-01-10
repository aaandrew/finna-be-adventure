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
	reverse(words, 0, words.length-1);

	// Reverse characters of each word
	int start = -1;
	for(int i=0; i<words.length; i++){
		if(words[i] == ' ' && start != -1){
			reverse(words, start, i-1);
			start = -1;
		}else if(i == words.length-1){
			reverse(words, start, i);
		}else if(start == -1){
			start = i;
		}
	}
}

public static void reverse(char[] arr, int start, int end){
	while(start < end){
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		start++; end--;
	}
}