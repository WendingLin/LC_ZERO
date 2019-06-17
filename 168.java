class Solution {
  public String convertToTitle(int n) {
    String res = "";
    while (n > 0) {
      int remain = (n - 1) % 26;
      n = (n - 1) / 26;
      res = (char)('A' + remain) + res;
    }
    return res;
  }
}
