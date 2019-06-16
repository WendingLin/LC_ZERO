class Solution {
  public boolean isOneEditDistance(String s, String t) {
    int len_s = s.length();
    int len_t = t.length();
    if (len_s == 0 && len_t == 0)
      return false;
    if (len_s == 0 || len_t == 0)
      return true;

    if (len_s - len_t == 1) { // s delete
      for (int i = 0; i < len_t; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          return s.substring(i + 1).equals(t.substring(i));
        }
      }
    } else if (len_s + 1 == len_t) { // s add
      for (int i = 0; i < len_s; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          return s.substring(i).equals(t.substring(i + 1));
        }
      }
    } else if (len_s == len_t) { // s replace
      for (int i = 0; i < len_t; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          return s.substring(i + 1).equals(t.substring(i + 1));
        }
      }
      return false;
    } else {
      return false;
    }

    return true;
  }
}
