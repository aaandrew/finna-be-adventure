// PRAMP
// This code is in js, convert to java later

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