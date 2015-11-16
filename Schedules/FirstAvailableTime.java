// PRAMP
// TODO: Write explanation + examples
// {10,11}, {5,9},{1,4}
// {1,3},{10,20},{6,9}

/* 
 * Given two time intervals and a meeting duration time,
 * find the first time both A and B are available. 
 */
public static int[] firstTimeAvailable(int[][] timeA, int[][] timeB, int duration){
   Comparator<int[]> comparator = new Comparator<int[]>(){
      @Override
      public int compare(int[] a, int[] b){
      // Compare the end times
         return a[1] - b[1];
      }
   };
   // Sort both arrays
   Arrays.sort(timeA, comparator);
   Arrays.sort(timeB, comparator);
   int a = 0;
   int b = 0;
   while(a < timeA.length && b < timeB.length){
      // Check if the overlap of the times fits within the duration
      int maxStartTime = Math.max(timeA[a][0], timeB[b][0]);
      int minEndTime = Math.min(timeA[a][1], timeB[b][1]);
      if(maxStartTime + duration <= minEndTime){
         return new int[]{maxStartTime, maxStartTime + duration};
      // Increment pointer with least end time
      }else if(timeA[a][1] < timeB[b][1]){
         a++;
      }else{
         b++;
      }
   }
   return new int[]{};
}