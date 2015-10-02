
public class AnagramOfPalindrome {
	
	/*
	 * Given a string, check if any anagram of it can be a palindrome.
	 * Ex. "AAC". Return true because "ACA" is palindrome.
	 * 
	 * Solution:
	 * Ensure that there is at most one odd occurring character in the stirng.
	 * 
	 */
	
	// Time: O(n)
	// Space: O(1)
	public static boolean isAnagramOfPalindrome(String input){
		int[] charMap = new int[256];
		
		int numEvenChars = 0;
		int numOddChars = 0;
		
		String lowercaseString = input.toLowerCase(); 
		
		for(int i=0; i<lowercaseString.length(); i++){
			charMap[lowercaseString.charAt(i)]++;
		}
		
		for(int i=0; i<charMap.length; i++){
			if(charMap[i] > 0){
				if(charMap[i] % 2 == 1){
					numOddChars++;
					if(numOddChars > 1)
						break;
				}else{
					numEvenChars++;
				}
			}
		}
		
		// Check if input can form a palindrome
		if(numOddChars > 1)
			return false;
		// Ensure that string is able to form another anagram palindrome
		// This accounts for single letter cases 'a', or single even number chars 'aba'
		else if(numEvenChars <= 1 && isAnagram(input))
			return false;
		
		return true;
	}
	
	 private static boolean isAnagram(String input){
		 int length = input.length();
		 for(int i=0; i<length/2; i++){
			 if(input.charAt(i) != input.charAt(length-i-1))
				 return false;
		 }
		 return true;
	 }
	 
	 // Variation:
	 // Given a two strings, return whether the second is an anagram of a palindrome
	 // of the first string
	 public static boolean isAnagramOfPalindrome(String input, String anagramPalindrome){
		 if(input.length() != anagramPalindrome.length())
			 return false;
		 
		 int[] charMap = new int[256];
		 String a = input.toLowerCase();
		 String b = anagramPalindrome.toLowerCase();
		 // used to check if other string is an anagram
		 boolean isDifferentString = false;
		 int numOddChars = 0;
		 
		 for(int i=0; i<a.length(); i++){
			 char charA = a.charAt(i);
			 char charB = b.charAt(i);
			 charMap[charA]++;
			 charMap[charB]--;
			 
			 if(charA != charB)
				 isDifferentString = true;
		 }
		 
		 for(int i=0; i<charMap.length; i++){
			 if(charMap[i] % 2 == 1){
				 if(numOddChars > 1)
					 return false;
				 numOddChars++;
			 }
		 }
		 return isDifferentString;
	 }
	 
	 
	
	public static void main(String[] args){
		System.out.println(isAnagramOfPalindrome("")); // False
		System.out.println(isAnagramOfPalindrome("aba")); // false, already the only anagram
		System.out.println(isAnagramOfPalindrome("a")); // false, already the only anagram
		System.out.println(isAnagramOfPalindrome("aabaa")); // False
		System.out.println(isAnagramOfPalindrome("abba")); // true
		System.out.println(isAnagramOfPalindrome("abcba")); // true
		
		System.out.println("//");
		
		System.out.println(isAnagramOfPalindrome("aba", "aba")); // False
		System.out.println(isAnagramOfPalindrome("abba", "baab")); // True
		System.out.println(isAnagramOfPalindrome("abcba", "bacab")); // True
		System.out.println(isAnagramOfPalindrome("a", "a")); // False

	}
}
