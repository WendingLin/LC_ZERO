// constructor
class Solution {
public:
  int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {

    int row = obstacleGrid.size();
    if (row == 0)
      return 0;
    int column = obstacleGrid[0].size();
    if (column == 0)
      return 0;
    long **dp = new long *[row]();

    for (int i = 0; i < row; i++)
      dp[i] = new long[column]();

    for (int i = 0; i < row; i++) {
      if (obstacleGrid[i][0] == 1)
        break;
      dp[i][0] = 1;
    }
    for (int j = 0; j < column; j++) {
      if (obstacleGrid[0][j] == 1)
        break;
      dp[0][j] = 1;
    }
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < column; j++) {
        if (obstacleGrid[i][j] == 1)
          dp[i][j] = 0;
        else
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[row - 1][column - 1];
  }
};
