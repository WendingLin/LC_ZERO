class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas.length == 0)
      return -1;
    int diff = 0;
    int pos = 0;
    int count = 0;
    for (int i = 0; i < gas.length; i++) {
      int temp = gas[i] - cost[i];
      count += temp;
      if (diff < 0) {
        diff = temp;
        pos = i;
      } else
        diff += temp;
    }
    if (count < 0)
      return -1;
    else
      return pos;
  }
}
