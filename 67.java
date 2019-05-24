class Solution {
  public String addBinary(String a, String b) {
    boolean ci = false;
    int posa = a.length() - 1;
    if (posa < 0)
      return b;
    int posb = b.length() - 1;
    if (posb < 0)
      return a;

    String res = "";
    while (posa >= 0 || posb >= 0) {
      char ca = (posa >= 0) ? a.charAt(posa) : '0';
      char cb = (posb >= 0) ? b.charAt(posb) : '0';
      boolean ba = (ca == '0') ? false : true;
      boolean bb = (cb == '0') ? false : true;

      if (ci == true) {
        if (ba == false && bb == false) {
          res = '1' + res;
          ci = false;
        } else {
          ca = (ba ^ bb ^ ci == false) ? '0' : '1';
          res = ca + res;
        }
      } else {
        if (ba == true && bb == true) {
          res = '0' + res;
          ci = true;
        } else {
          ca = (ba ^ bb == false) ? '0' : '1';
          res = ca + res;
        }
      }
      posa--;
      posb--;
    }
    if (ci == true)
      res = '1' + res;
    return res;
  }
}
