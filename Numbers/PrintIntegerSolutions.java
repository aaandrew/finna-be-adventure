/* CTCI
 * Print all positive integer solutions to the equation:
 * a^k + b^k = c^k + d^k
 * for all a,b,c,d < n
 * Don't print out permutations, or trivial solutions
 * ie. (1,2) and (1,2) or (1,2) and (2,1)
 */

// Brute force
// Time: O(n^4)
public static void printSolutions(int k, int n){
	for(int a=1; a<n; a++){
		for(int b=1; b<n; b++){
			for(int c=1; c<n; c++){
				for(int d=1; d<n; d++){
					int left = (int) (Math.pow(a,k) + Math.pow(b,k));
					int right = (int) (Math.pow(c,k) + Math.pow(d,k));
					if(left == right && a != c && b != d && b != c && a != d){
						System.out.println(a + "," + b + "," + c + "," + d);
					}
				}
			}
		}
	}
}

// Optimized
// Fix this later to get rid of permutations
// O(n^2)
public static void printSolutions(int k, int n){
	Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
	for(int c=1; c<n; c++){
		for(int d=1; d<n; d++){
			int result = (int) (Math.pow(c,k) + Math.pow(d,k));
			if(map.containsKey(result)){
				map.get(result).add(new Pair(c,d));
			}else{
				List<Pair> list = new ArrayList<Pair>();
				list.add(new Pair(c,d));
				map.put(result, list);
			}
		}
	}

	for(int result : map.keySet()){
		List<Pair> list = map.get(result);
		for(Pair a : list){
			for(Pair b : list){
				if(!a.compare(b)){
					System.out.println(a.x+ "," + a.y + "," + b.x + "," + b.y);
				}
			}
		}
	}
}

class Pair {
	int x,y;
	public Pair(int x, int y){
		this.x = x; this.y = y;
	}

	// Compare function 
	// Disregards permutations
	public boolean compare(Pair other){
		if(x == other.x && y == other.y || x == other.y && y == other.x)
			return true;
		return false;
	}

}
