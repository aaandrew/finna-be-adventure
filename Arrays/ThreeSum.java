/* Leetcode
 * Find all unique triplets in the array which gives the sum of zero.
 * Ex. Given array S = {-1 0 1 2 -1 -4},
    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

// Time: O(n^2)
public List<List<Integer>> threeSum(int[] num) {
	Arrays.sort(num);
	List<List<Integer>> res = new LinkedList<>(); 
	for(int i=0; i<num.length-2; i++){
		if(i > 0 && num[i] == num[i-1])
			continue;
		int target = -num[i], low = i+1, high = num.length-1;
		while(low < high){
			if(num[low] + num[high] == target){
				res.add(Arrays.asList(num[i], num[low], num[high]));
				while (low < high && num[low] == num[low+1]) low++;
				while (low < high && num[high] == num[high-1]) high--;
				low++; high--;
			}else if(num[low] + num[high] < target){
				low++;
			}else{
				high--;
			}
		}
	}
	return res;
}


// With Target
// Time: O(n^2)
// Space: O(1)
public static boolean threeSum(int[] nums, int target){
		if(nums == null) return false;
		Arrays.sort(nums);
		for(int i=0; i<nums.length-1; i++){
			int n = target-nums[i], low = i+1, high = nums.length-1;
			while(low < high){
				if(nums[low] + nums[high] == n) return true;
				if(nums[low] + nums[high] < n){
					low++;
				}else{
					high--;
				}
			}
		}
		return false;
	}