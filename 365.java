class Solution {
  private int getGCD(int x, int y) {
    if (x == y)
      return x;
    if (x == 0 || y == 0)
      return Math.max(x, y);
    int a = (x < y) ? x : y; // a smaller
    int b = (x < y) ? y : x;
    while (a != 0 && b != 0) {
      int temp = a;
      a = b % a;
      b = temp;
      if (a == 0)
        return temp;
    }
    return 1;
  }
  public boolean canMeasureWater(int x, int y, int z) {
    if (x == 0 && y == 0)
      return true & (z == 0);
    int gcd = getGCD(x, y);
    if (z % gcd == 0 && z <= x + y)
      return true;
    else
      return false;
  }
}
