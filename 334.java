class Solution {
  public boolean increasingTriplet(int[] nums) {
    int n = nums.length;
    if (n < 3)
      return false;
    int min = nums[0];
    int dp2[] = new int[n]; // From [0, i] min second
    dp2[0] = -1;
    for (int i = 1; i < n; i++) {
      if (nums[i] > dp2[i - 1] && dp2[i - 1] != -1)
        return true;
      if (nums[i] > min) { // update dp2[i]
        dp2[i] = nums[i];
      } else {
        dp2[i] = dp2[i - 1];
        min = nums[i];
      }
    }
    return false;
  }
}
