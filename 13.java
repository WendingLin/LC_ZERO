class Solution {
  public int romanToInt(String s) {
    if (s == null || s.length() == 0)
      return 0;
    int res = 0;
    int status = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'I') {
        if (i != s.length() - 1 &&
            (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
          res -= 1;
        } else {
          res += 1;
        }
      } else if (c == 'V') {
        res += 5;
      } else if (c == 'X') {
        if (i != s.length() - 1 &&
            (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
          res -= 10;
        } else {
          res += 10;
        }
      } else if (c == 'L') {
        res += 50;
      } else if (c == 'C') {
        if (i != s.length() - 1 &&
            (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
          res -= 100;
        } else {
          res += 100;
        }
      } else if (c == 'D') {
        res += 500;
      } else {
        res += 1000;
      }
    }

    return res;
  }
}
