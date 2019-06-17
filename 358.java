class Solution {

  public String rearrangeString(String s, int k) {
    if (k == 1)
      return s;
    char[] res = new char[s.length()];
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(
        map.size(), (a, b) -> map.get(b) - map.get(a));

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      maxHeap.add(entry.getKey());
    }

    int index = 0;
    Queue<Character> q = new LinkedList();
    while (index < s.length()) {

      if (maxHeap.isEmpty() == true) {
        return "";
      }
      char c = maxHeap.poll();
      res[index] = c;
      q.add(c);

      if (q.size() >= k) {
        char nc = q.poll();
        int remain = map.get(nc);
        if (--remain > 0) {
          map.put(nc, remain);
          maxHeap.add(nc);
        }
      }

      index++;
    }

    return new String(res);
  }
}
