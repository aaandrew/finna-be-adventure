// Leetcode
// Fix this problem

public static List<String> summaryRanges(int[] nums) {
	int size = nums.length;
	List<String> result = new ArrayList<String>();
	
	if(size == 0) return result;
	int start = 0;
	
	while(start < size){
		int curr = start;
		int end = start+1;
		int count = 1;
		if(end == size){
			result.add(""+nums[start]);
			break;
		}
		
		while(end < size && nums[curr]+1 == nums[end]){
			count++;
			curr++;
			end++;
		}
		if(count > 1){
			result.add(nums[start] + "->" + nums[end-1]);
		}else{
			result.add(""+nums[start]);
		}
		start = end;
	}        
	return result;
}