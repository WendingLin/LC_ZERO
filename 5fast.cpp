class Solution {
public:
  string longestPalindrome(string s) {
    int n = s.length();
    if (n < 2)
      return s;
    string res = "";
    vector<vector<bool>> dp(n + 1, vector<bool>(n + 1, 0));
    for (int i = 0; i < n; ++i)
      dp[i][i] = true;
    int pos = 0, maxLen = 1;
    for (int i = n - 2; i >= 0; --i) {
      for (int j = i + 1; j < n; ++j) {
        if (s[i] == s[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          if (j - i + 1 > maxLen) {
            maxLen = j - i + 1;
            pos = i;
          }
        }
      }
    }
    for (int i = pos; i < pos + maxLen; ++i)
      res += s[i];
    return res;
  }
};
