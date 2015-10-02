/* Leetcode
 * 
 * Ex.
 * input: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * output: [
					  ["ate", "eat","tea"],
					  ["nat","tan"],
					  ["bat"]
					]
 */


// Naive solution
// Time: O(NMLogM + MNLogN), N words, M characters.
// First is for sorting individual words. Second is for sorting array of words
// Space: O(n)
public List<List<String>> groupAnagrams(String[] strs) {
	Arrays.sort(strs);
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	for(String s : strs){
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);

		if(map.containsKey(sorted)){
			map.get(sorted).add(s);
		}else{
			List<String> arr = new ArrayList<String>();
			arr.add(s);
			map.put(sorted, arr);
		}
	}
	List<List<String>> result = new ArrayList<List<String>>();
	for(String key : map.keySet()){
		result.add(map.get(key));
	}
	return result;
}


// Optimal Solution
// Define a hash function such that hash(a) == hash(b) if they are anagrams