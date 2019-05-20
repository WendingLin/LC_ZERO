class Solution {
  public String getHint(String secret, String guess) {
    int bull = 0;
    int cow = 0;
    int[] nums = new int[10];
    for (int i = 0; i < secret.length(); i++) {
      int s = Character.getNumericValue(secret.charAt(i));
      int g = Character.getNumericValue(guess.charAt(i));
      if (s == g)
        bull++;
      else {
        if (nums[s] < 0)
          cow++;
        if (nums[g] > 0)
          cow++;
        nums[s]++;
        nums[g]--;
      }
    }

    String result = bull + "A" + cow + "B";
    return result;
  }
}
