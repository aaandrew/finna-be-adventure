// PRAMP
// TODO Fix this code it sucks 

// Find min and increment 1 until number is not in set
// Time: O(n)
// Space: O(1)
public Integer getDiff(int[] arr, int n){
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

   for(int i=0; i<n; i++){
      if(!set.contains(min + 1)){
         return min + 1;
      }else{
         min++;
      }
   }

   if(set.contains(min+1)){
      return null;
   }
   
   return min+1;
}   
}
