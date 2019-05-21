class Solution {
  public boolean containsDuplicate(int[] nums) {
    HashSet records = new HashSet();
    for (int num : nums) {
      if (records.add(num) == false)
        return true;
    }
    return false;
  }
}
