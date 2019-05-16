// Final Check
class Solution {
public:
  bool isValid(string s) {
    stack<char> records;
    for (auto c : s) {
      if (c == '(' || c == '{' || c == '[')
        records.push(c);
      else {
        if (records.empty() || (c == ')' && records.top() != '(') ||
            (c == ']' && records.top() != '[') ||
            (c == '}' && records.top() != '{'))
          return false;
        else
          records.pop();
      }
    }
    if (records.empty())
      return true;
    else
      return false;
  }
};
