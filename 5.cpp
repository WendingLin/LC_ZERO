class Solution {
public:
  string longestPalindrome(string s) {
    if (s.empty())
      return "";
    else if (s.size() == 1)
      return s;
    string sub = "";
    int len = s.size();
    bool **dp = new bool *[len]();
    for (auto i = 0; i < len; i++)
      dp[i] = new bool[len]();

    for (auto i = 0; i < len; i++) {
      dp[i][i] = true;
      sub = s[i];
    }

    for (auto i = 0; i < len; i++) {
      for (auto j = 0; j < len; j++) {
        if (i == j) {
          continue;
        } else if (i + 1 == j && s[i] == s[j]) {
          dp[i][j] = true;
          sub = s.substr(i, 2);
        } else
          dp[i][j] = false;
      }
    }

    bool *flag = new bool[len]();
    flag[0] = true;
    flag[1] = true;
    for (int i = 2; i < len; i++) {
      for (int j = 0; j < len - i; j++) {
        if (dp[j + 1][j + i - 1] && s[j] == s[j + i]) {
          dp[j][j + i] = true;
          sub = s.substr(j, i + 1);
          flag[i] = true;
        }
      }
      if (flag[i - 1] == false && flag[i - 2] == false)
        break;
    }
    return sub;
  }
};
