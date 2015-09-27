/*
 * Count the number of substrings (non overlapping) in a string
 */

// Brute force
// Time: O(n*m) where m = length of substring
public int countSubstrings(String string, String sub){
	int count = 0;
	for(int i=0; i<string.length(); i++){
		if(string.charAt(i) == sub.charAt(0)){
			for(int j=0, temp = i; j<sub.length() && temp <string.length(); j++, temp++){
				if(string.charAt(temp) == sub.charAt(j)){
					if(j + 1 == sub.length())
						count++;
						i = temp + 1;
				}else{
					break;
				}
			}
		}
	}
	return count;
}

// Naive: Using built in replace
// Time: O(n*m)
public static int countSubstrings(String string, String sub){
	return (string.length() - string.replace(sub, "").length()) / sub.length();
}

// KMP Algoirthm
// Time: O(n+m)
// Worst case: All prefixes in table are 0

// Generate prefix table according to KMP
// Time: O(m)
private static int[] generatePrefixTable(String pattern){
	char[] chars = pattern.toCharArray();
	int[] table = new int[chars.length+1];

	table[1] = 0;
	int a = 0;

	for(int b=2; b<chars.length; b++){
		while(a>0 && table[a+1] != table[b]){
			a = table[a];
		}

		// Increment the longest prefix
		if(table[a+1] == table[b]){
			a++;
		}
		table[b] = a;
	}
	return table;
}

// Time: O(n)
public static int kmp(char[] string, char[] sub, int[] prefixTable){
	int count = 0;
	int stringp = 0;
	int subp = 0;

	while(stringp + subp < string.length){

		// Keep iterating if char matches
		if(string[stringp + subp] == sub[subp]){
			subp++;
			if(subp == sub.length){
				count++;
			}else{
				continue;
			}
		}

		stringp += subp - prefixTable[subp];
		if(subp > 0){
			subp = prefixTable[subp];
		}
	}
	return count;
}

// Time: O(n+m)
public static int countSubstrings(String string, String sub){
	return kmp(string.toCharArray(), sub.toCharArray(), generatePrefixTable(sub));
}

// Test cases
countSubstrings("abcdefgcde", "cde") == 2
countSubstrings("ababababab","abab") == 2
