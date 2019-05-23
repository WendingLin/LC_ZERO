class Solution {
  public int findDuplicate(int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int count = 0;
      int mid = left + (right - left) / 2;
      for (int num : nums) {
        if (num <= mid)
          count++;
      }
      if (count > mid)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return left;
  }
}
