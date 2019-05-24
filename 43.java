class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0"))
      return "0";
    int len1 = num1.length();
    int len2 = num2.length();

    String res = "";
    int ci = 0;
    for (int i = 0; i < len1 + len2 - 1; i++) {
      int val = ci;
      for (int m = 0; m <= i; m++) {
        int posa = len1 - 1 - m;
        int posb = len2 - 1 - i + m;
        if (posa < 0 || posb < 0)
          continue;
        int c1 = Character.getNumericValue(num1.charAt(posa));
        int c2 = Character.getNumericValue(num2.charAt(posb));
        val += c1 * c2;
      }
      ci = val / 10;
      res = Integer.toString(val % 10) + res;
    }
    if (ci != 0)
      res = Integer.toString(ci) + res;
    return res;
  }
}
