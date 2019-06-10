class Solution {
  public String reverseWords(String s) {
    boolean inword = false;
    String res = "";
    String tempword = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ' && inword == false)
        continue;
      else if (c == ' ' && inword == true) {
        inword = false;
        res = c + tempword + res;
        tempword = "";
      } else {
        if (inword == false) {
          inword = true;
        }
        tempword += c;
        if (i + 1 == s.length())
          res = tempword + res;
      }
    }
    if (res.length() > 0 && res.charAt(0) == ' ')
      res = res.substring(1);
    return res;
  }
}
