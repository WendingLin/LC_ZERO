class Solution {
  public int maxArea(int[] height) {
    int len = height.length;
    int left = 0;
    int right = len - 1;
    int max = 0;
    while (left != right) {
      int val = Math.min(height[left], height[right]) * (right - left);
      max = Math.max(val, max);
      if (height[left] < height[right])
        left++;
      else
        right--;
    }
    return max;
  }
}
