/* CTCI (page 75)
 * Given two sorted arrays, find common elements between them.
 * Don't use extra memory
 */ 

// TODO: Fix this to work for any arrays
// Time: O(n)
// Space: O(1)
public static List<Integer> findDups(int[] a, int[] b){
	List<Integer> result = new ArrayList<Integer>();
	int ap = 0, bp = 0;
	while(ap < a.length){
		if(a[ap] == b[bp]){
			result.add(a[ap]);
			ap++;
			bp++;
		}
		else if(a[ap] > b[bp]){
			bp++;
		}else{
			ap++;
		}
	}
	return result;
}