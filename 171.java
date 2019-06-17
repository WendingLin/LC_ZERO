class Solution {
  public int titleToNumber(String s) {
    int coe = 1;
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(s.length() - 1 - i);
      res += (int)(c - 'A' + 1) * coe;
      coe *= 26;
    }
    return res;
  }
}
