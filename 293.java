class Solution {
  public List<String> generatePossibleNextMoves(String s) {
    List<String> res = new ArrayList<String>();
    int index = 0;
    while (index < s.length() - 1) {
      while (index < s.length() - 1 &&
             !(s.substring(index, index + 2).equals("++") == true)) {
        index++;
      }
      if (index < s.length() - 1) {
        res.add(s.substring(0, index) + "--" +
                s.substring(index + 2, s.length()));
        index += 1;
      }
    }
    return res;
  }
}
