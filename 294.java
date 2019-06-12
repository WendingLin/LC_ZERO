class Solution {
  public boolean canWin(String s) {
    if (s == null || s.length() < 2) {
      return false;
    }
    int len = s.length();
    for (int i = 0; i < len - 1; i++) {
      if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
        String new_str = s.substring(0, i) + "--" + s.substring(i + 2, len);
        if (canWin(new_str) == false)
          return true;
      }
    }
    return false;
  }
}
