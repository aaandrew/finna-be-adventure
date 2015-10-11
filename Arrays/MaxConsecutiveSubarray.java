/*
  Find length of longest consecutive sequence in an array.
  e.g. [0, 3, 4, 5, 6, 1, 2] -> 4 for 3, 4, 5, 6
 */ 
  

public static int sequence(int[] arr){
  if(arr == null || arr.length == 0)
    return 0;
  int count = 1;
  int maxCount = count;

  for(int i=0; i<arr.length-1; i++){
    if(arr[i] + 1 == arr[i+1]){
      count++;
    }else{
      if(count > maxCount){
        maxCount = count;
        count = 1;
      }
    }
  }

  if(count > maxCount)
    maxCount = count;

  return maxCount
}

// Followup: What about a binary tree?
//      0
//    1   3
// 2         4
//         5    6

// -> 3 for 3, 4, 5
  
//   0->1->2
//   3->4->5