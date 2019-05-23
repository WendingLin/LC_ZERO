class Solution {
  public int reverse(int x) {
    long res = 0;
    int num[] = new int[10];
    int counter = 0;
    while (x != 0) {
      num[counter++] = x % 10;
      x = x / 10;
    }
    long coe = 1;
    boolean flag = false;
    for (int i = 9; i >= 0; i--) {
      if (num[i] != 0 || flag) {
        flag = true;
        res += (num[i] * coe);
        coe *= 10;
      }
    }
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
      return 0;
    else
      return Math.toIntExact(res);
  }
}
