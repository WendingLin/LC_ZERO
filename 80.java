class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;
    int count = 0;
    boolean once = false;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] == nums[i]) {
        if (once == false) {
          once = true;
          nums[count++] = nums[i];
        }
      } else {
        nums[count++] = nums[i];
        once = false;
      }
    }
    nums[count++] = nums[nums.length - 1];
    return count;
  }
}
