// dp transfer equation
class Solution {
public:
  int maxSubArray(vector<int> &nums) {
    if (nums.size() == 0)
      return 0;
    int *dp = new int[nums.size()];
    int max_num = nums[0];
    dp[0] = nums[0];
    for (int i = 1; i < nums.size(); i++) {
      if (dp[i - 1] < 0)
        dp[i] = nums[i];
      else
        dp[i] = dp[i - 1] + nums[i];
      max_num = max(max_num, dp[i]);
    }
    delete[] dp;
    return max_num;
  }
};
