// PRAMP
// This code is in js, convert to java later

A = [[4,8],[1,3],[9,10],[]]
B = [[],[],[],[]]

/* 
 * Given two time intervals and a meeting duration time,
 * find the first time both A and B are available. 
 */
public static int[] getMinDuration(int[][] timeA, int[][] timeB, int duration){
   // Sort both time schedules
   Comparator<int[]> comparator = new Comparator<int[]>(){
     @Override
     public int compare(final int[] a, final int[] b){
      // Compare the end times
      return a[1] - b[1];
   };

   Arrays.sort(timeA, comparator);
   Arrays.sort(timeB, comparator);


}

function getMinDuration(timeA, timeB, duration){
   sort(timeA, comparator); sort(timeB, comparator);
   
   var a = 0; 
   var b = 0;
   
   while(a < timeA.length && b < timeB.length){
      var maxStartTime = Math.max(timeA[a][0], timeB[b][0]);
      var minEndTime = Math.min(timeA[a][1], timeB[b][1]);
      if(minEndTime - maxStartTime + 1 >= duration){
         return [maxStartTime, maxStartTime + duration];
      }else if(timeA[a][1] < timeB[b][1]){
         a++;
      }else{
         b++;
      }
   }
   return [];
}