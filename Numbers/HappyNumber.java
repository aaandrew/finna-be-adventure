// Leetcode


// Fast/Slow pointer
public boolean isHappy(int n) {
  int cur = n;
  int next = n;
  do{
    cur = happy(cur);
    next = happy(happy(next));
  }while(cur != next);
  if(cur == 1) return true;
  return false;
}

// Set solution
class Main {
  public static int count = 0;
  
  public static void main(String[] args) {
    int[] input = new int[]{
      101704,
      9,
      1355,
      52921,
      6,
      97,
      761,
      136,
      1932,
      78
    };
    
    for(int i=0; i<input.length; i++){
      count = 0;
      if (isHappy(input[i]))
        System.out.println("happy " + count);
      else
        System.out.println("unhappy " + count);
    }

  }
  
  public static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<Integer>();
    while(true){
      n = happy(n);
      count++;
      if (set.contains(n))
        return false;
      set.add(n);
      if(n == 1) return true;
    }
  }
  
  public static int happy(int n){
    int sum = 0;
    while(n != 0){
      int digit = n%10;
      sum += digit * digit;
      n/=10;
    }
    return sum;
  }
}