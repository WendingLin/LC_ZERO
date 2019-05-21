class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Integer> numset = new TreeSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (numset.floor(nums[i]) != null &&
          (t + numset.floor(nums[i]) >= nums[i]))
        return true;
      else if (numset.ceiling(nums[i]) != null &&
               (numset.ceiling(nums[i]) - t <= nums[i]))
        return true;
      else {
        numset.add(nums[i]);
      }
      if (i >= k)
        numset.remove(nums[i - k]);
    }
    return false;
  }
}
