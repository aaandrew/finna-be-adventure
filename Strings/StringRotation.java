/* CTCI
 * Assume you have a method isSubstring which checks if one word
 * is a substring of another. Given two strings a and b, check if b
 * is a rotation of a using one call to isSubstring
 * Example
 * 'waterbottle' is a rotation of 'erbottlewat'
 */

// Explanation
// x = wat
// y = erbottle
// xy = waterbottle
// yx = erbottlewat
// Check new string yxyx for the substring xy
// Time: O(a+b)
// Space: O(b)
public boolean isRotation(String a, String b){
	if(a.length() != b.length()) return false;
	return isSubstring(a, b+b);
}