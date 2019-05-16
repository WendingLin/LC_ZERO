// Transfer equation -1 -2
class Solution {
public:
  int uniquePaths(int m, int n) {
    if (m == 0 || n == 0)
      return 0;
    if (m == 1 || n == 1)
      return 1;
    int **dp = new int *[m];
    for (int i = 0; i < m; i++)
      dp[i] = new int[n];
    for (auto i = 0; i < m; i++)
      dp[i][0] = 1;
    for (auto j = 0; j < n; j++)
      dp[0][j] = 1;
    for (auto i = 1; i < m; i++) {
      for (auto j = 1; j < n; j++)
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
    return dp[m - 1][n - 1];
  }
};
