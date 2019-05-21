class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> num_pos = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (num_pos.containsKey(nums[i])) {
        int distance = i - num_pos.get(nums[i]);
        if (distance <= k)
          return true;
        else
          num_pos.put(nums[i], i);
      } else {
        num_pos.put(nums[i], i);
      }
    }
    return false;
  }
}
