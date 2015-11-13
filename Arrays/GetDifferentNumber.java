/* Pramp
 * Given an array of n unique integers, how can you efficiently find an
 * integer that is not in the array?
 * Return null if the arr contains all possible integers.
 */

// Find min and increment 1 until number is not in set
// Time: O(n)
// Space: O(1)
public Integer getDiff(int[] arr, int n){
   // Small check to test if arr contains all possible ints
   if(n == Integer.MAX_VALUE) return null;
   Set<Integer> set = new HashSet<Integer>();
   int min = Integer.MAX_VALUE;
   // Loop, find min, find max, fill the set
   for(int i=0; i<arr.length; i++){
      // Check min
      if(arr[i] < min){
         min = arr[i];
      }
      // Add to set
      if(set.size() < n){
         set.add(arr[i]);
      }else{
         break;
      }
   }
   for(int i=1; i<n; i++){
      if(!set.contains(min + 1)){
         return min + 1;
      }else{
         min++;
      }
   }
   // Robust check to see if arr contains all possible ints
   if(set.contains(min+1)){
      return null;
   }
   return min+1;
}
