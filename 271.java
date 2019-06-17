public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    String res = "";
    for (String str : strs) {
      int len = str.length();
      res += String.valueOf(len) + '/' + str;
    }
    return res;
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> res = new ArrayList<String>();
    int index = 0;
    while (index < s.length()) {
      int i = index;
      while (s.charAt(i) != '/') {
        i++;
      }
      int len = Integer.parseInt(s.substring(index, i));
      res.add(s.substring(i + 1, i + 1 + len));
      index = i + 1 + len;
    }
    return res;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
