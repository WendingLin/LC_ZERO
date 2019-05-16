class Solution {
public:
  string longestPalindrome(string s) {
    if (s.empty())
      return "";
    else if (s.size() == 1)
      return s;
    string sub = "";
    int len = s.size();
    int max_len = 0;
    vector<vector<bool>> dp(len, vector<bool>(len, 0));

    for (auto i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    bool *flag = new bool[len]();
    flag[0] = true;
    int pos = 0;
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < len - i; j++) {
        if ((dp[j + 1][j + i - 1] || i == 1) && s[j] == s[j + i]) {
          dp[j][j + i] = true;
          flag[i] = true;
          pos = j;
        }
      }
      if (flag[i])
        max_len = i;
      if (flag[i - 1] == false && i != 1 && flag[i - 2] == false)
        break;
    }
    for (int i = pos; i < pos + max_len + 1; ++i)
      sub += s[i];
    return sub;
  }
};
