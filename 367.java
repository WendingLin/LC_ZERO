class Solution {
  public boolean isPerfectSquare(int num) {
    if (num == 1)
      return true;
    long left = 0;
    long right = num;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      if (num / mid == mid && num % mid == 0)
        return true;
      else if (num / mid < mid)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return false;
  }
}
