/* CTCI (page 75)
 * Given two sorted arrays, find common elements between them.
 * Don't use extra memory
 */ 

// TODO: Fix this to work for any arrays
// Works well for m ~ n
// Time: O(n)
// Space: O(1)
public static List<Integer> findDups(int[] a, int[] b){
	List<Integer> result = new ArrayList<Integer>();
	int ap = 0, bp = 0;
	while(ap < a.length && bp < b.length){
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

// Works well for m >>> n
// Time: O(n*logm)
// Space: O(1)
public List<Integer> findDups(int[] m, int[] n){
	List<Integer> result = new ArrayList<Integer>();
	if(m == null || n == null)
		return result;

	for(int i=0; i<n.length; i++){
		if(bsearch(m, n[i]) != -1){
			result.add(n[i]);
		}
	}
	return result;
}

// returns index
// -1 = no match
// {1,2,3}
public int bsearch(int[] m, int value){
	int start = 0, end = m.length;

	while(start < end){
		int mid = (end-start)/2 + start;
		if(m[mid] == value){
			return mid;
		}else if(m[mid] < value){
			start = mid + 1;
		}else{
			end = mid;
		}
	}
	return -1;
}