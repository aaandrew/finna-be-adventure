
// Time: O(n)
// Space: O(n)
public static String add(String s1, String s2) {
  String result = "";
  int carry = 0, d1, d2;
  int length = Math.max(s1.length(), s2.length());
  for (int i = 0; i < length; i++) {
    d1 = val(s1, i);
    d2 = val(s2, i);
    int dsum = d1 + d2 + carry;
    result = (dsum % 10) + result;
    carry = dsum / 10;
  }
  if (carry > 0) {
    result = carry + result;
  }
  return result;
}

private static int val(String s, int i) {
  if (i >= s.length()) {
    return 0;
  } else {
    return Character.getNumericValue(s.charAt(s.length() - i - 1));
  }
}