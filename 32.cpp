// first pop then i-pos_stack.top()
class Solution {
public:
  int longestValidParentheses(string s) {
    stack<int> pos_stack;
    int max_len = 0;
    int start = 0;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == ')') {
        if (pos_stack.empty()) {
          start = i + 1;
        } else {
          pos_stack.pop();
          int curr_max =
              pos_stack.empty() ? i - start + 1 : i - pos_stack.top();
          max_len = max(max_len, curr_max);
        }
      } else
        pos_stack.push(i);
    }
    return max_len;
  }
};
