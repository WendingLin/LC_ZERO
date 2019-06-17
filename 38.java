class Solution {
  public String countAndSay(int n) {
    if (n == 1)
      return "1";
    String res = countAndSay(n - 1) + '*';
    char[] ca = res.toCharArray();
    res = "";
    int count = 1;
    for (int i = 0; i < ca.length - 1; i++) {
      if (ca[i] == ca[i + 1]) {
        count++; //计数增加
      } else {
        res = res + count + ca[i]; //上面的*标记这里方便统一处理
        count = 1;                 //初始化
      }
    }

    return res;
  }
}
