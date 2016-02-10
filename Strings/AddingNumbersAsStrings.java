// Big Integer or add numbres as strings

// Time: O(n)
// Space: O(n)
public static String bigAdd(String a, String b) {
  if(a == null && b == null) return null;
  if(a == null || a.isEmpty()) return b;
  if(b == null || b.isEmpty()) return a;

  StringBuilder sb = new StringBuilder();
  int carry = 0;
  int alength =  a.length(), blength = b.length();
  int length = Math.max(alength, blength);

  for(int i=0; i<length; i++){
    int adigit = (i<alength) ? a.charAt(alength-i-1) - '0' : 0;
    int bdigit = (i<blength) ? b.charAt(blength-i-1) - '0' : 0;
    int sum = adigit + bdigit + carry;

    sb.append(sum % 10);
    carry = sum / 10;
  }

    // Check carry
  if(carry > 0){
    sb.append(carry);
  }

  return sb.reverse().toString();
}