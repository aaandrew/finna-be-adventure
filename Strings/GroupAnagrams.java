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
// Time: O(n*m)
public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            int[] counts = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                counts[c - 'a']++;
            }
            String key = hashkey(counts);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> tempList = new ArrayList<String>();
                tempList.add(strs[i]);
                map.put(key, tempList);
            }
        }
        
        List<List<String>> list = new ArrayList<List<String>>();
        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
    
    private String hashkey(int[] counts){
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i=0; i<counts.length; i++){
            sb.append(c + String.valueOf(counts[i]));
            c++;
        }
        return sb.toString();
    }