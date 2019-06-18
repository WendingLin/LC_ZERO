class Solution {

  public List<String> findStrobogrammatic(int n) { return helper(n, n); }
  public List<String> helper(int n, int m) {
    if (n == 0)
      return new ArrayList<String>(Arrays.asList(""));
    if (n == 1)
      return new ArrayList<String>(Arrays.asList("0", "1", "8"));

    List<String> last = helper(n - 2, m);

    List<String> res = new ArrayList<String>();
    for (int i = 0; i < last.size(); i++) {
      String addin = last.get(i);
      if (n != m) {
        res.add('0' + addin + '0');
      }
      res.add('1' + addin + '1');
      res.add('6' + addin + '9');
      res.add('8' + addin + '8');
      res.add('9' + addin + '6');
    }

    return res;
  }
}
