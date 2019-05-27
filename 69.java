class Solution {
  public int mySqrt(int x) {
    if (x == 0)
      return 0;
    long left = 0;
    long right = x;
    long mid = (right - left) / 2 + left;
    while (left <= right) {
      mid = (right - left) / 2 + left;
      if (mid > 46341) {
        right = mid - 1;
        continue;
      }
      long res = mid * mid;
      if (res > x)
        right = mid - 1;
      else if (res < x)
        left = mid + 1;
      else
        return Math.toIntExact(mid);
    }
    return Math.toIntExact(right);
  }
}
