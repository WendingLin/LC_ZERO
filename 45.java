class Solution {
  public int jump(int[] nums) {
    if (nums.length < 2)
      return 0;
    int reach = 0;
    int max = 0;
    int res = 0;
    for (int i = 0; i < nums.length; i++) {

      if (reach < i) {
        res++;
        reach = max;
      }
      max = Math.max(max, i + nums[i]);
    }
    return res;
  }
}
