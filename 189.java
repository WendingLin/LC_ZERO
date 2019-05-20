class Solution {
  public void rotate(int[] nums, int k) {
    if (nums.length == 0)
      return;
    int len = nums.length;
    int count = 0;
    for (int start = 0; count < len; start++) {
      int last = nums[start];
      int curr_pos = start;
      do {
        int next_pos = (curr_pos + k) % len;
        int temp = nums[next_pos];
        nums[next_pos] = last;
        last = temp;
        curr_pos = next_pos;
        count++;
      } while (curr_pos != start);
    }
    return;
  }
}
