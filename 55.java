class Solution {
  public boolean canJump(int[] nums) {
    if (nums.length < 2)
      return true;
    int max_len = nums[0];
    for (int i = 0; i < Math.min(max_len + 1, nums.length - 1); i++) {
      max_len = Math.max(i + nums[i], max_len);
      if (max_len >= nums.length - 1)
        return true;
    }
    return false;
  }
}
