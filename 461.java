class Solution {
  public int hammingDistance(int x, int y) {
    int a = x ^ y;
    int res = 0;
    for (int i = 31; i >= 0; i--) {
      if ((a & (1 << i)) != 0)
        res++;
    }
    return res;
  }
}
