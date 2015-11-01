/*
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], 
	write a function search(char pat[], char txt[]) that 
	prints all occurrences of pat[] and its permutations 
	(or anagrams) in txt[]. You may assume that n > m. 
 */

public List<String> search(String prefix, String string){
	int prefixLength = prefix.length();
	List<String> result = new ArrayList<String>();
	int[] freqs = new int[256];
	int[] windowFreqs = new int[256];
	for(int i=0; i<prefixLength; i++){
		freqs[prefix.charAt(i)]++;
		windowFreqs[string.charAt(i)]++;
	}

	for(int i=prefixLength; i<string.length(); i++){
		char c = string.charAt(i);
		if(compare(freqs, windowFreqs)){
			result.add(string.substring(i-prefixLength, i+1));
		}
		windowFreqs[c]++;
		windowFreqs[string.charAt(i-prefixLength)]--;
	}

	if(compare(freqs, windowFreqs)){
		result.add(string.substring(string.length()-prefixLength));
	}
	return result;
}

public boolean compare(int[] a, int[] b){
	for(int i=0; i<a.length; i++){
		if(a[i] != b[i]) return false;
	}
	return true;
}
