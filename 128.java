class Solution {
  public int longestConsecutive(int[] nums) {
    int n = nums.length;
    if (n < 2)
      return n;
    HashSet<Integer> num_set = new HashSet<Integer>();
    for (int num : nums)
      num_set.add(num);

    int max = 0;
    for (int num : nums) {
      if (!num_set.contains(num - 1)) {
        int curr = num + 1;
        int len = 1;
        while (num_set.contains(curr)) {
          curr++;
          len++;
        }

        max = Math.max(max, len);
      }
    }
    return max;
  }
}
