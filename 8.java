class Solution {
  public int myAtoi(String str) {
    long res = 0;
    int status = 0;
    boolean flag = false;
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (status == 0) {
        char x = str.charAt(i);
        if (x == ' ') {
          continue;
        } else if (x == '+') {
          status = 1;
        } else if (x == '-') {
          status = 1;
          flag = true;
        } else if (Character.isDigit(x) == true) {
          status = 1;
          res = Character.getNumericValue(x);
          if (res != 0) {
            count++;
          }
        } else {
          return 0;
        }
      } else {
        if (count == 11)
          break;
        char m = str.charAt(i);
        if (Character.isDigit(m)) {
          res = res * 10 + Character.getNumericValue(m);
          if (res != 0) {
            count++;
          }
        } else {
          break;
        }
      }
    }
    if (flag == true)
      res = -1 * res;
    if (res > Integer.MAX_VALUE)
      return Integer.MAX_VALUE;
    if (res < Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    return Math.toIntExact(res);
  }
}
