class Solution {
    private int helper(int[] nums, int left, int right, int k){
        if(left == right)
            return nums[left];
        int mid = left + (right-left)/2;
        int pivot = nums[mid];
        int i = left, j =right;
        while(i<=j){
            while(i<=j && nums[i]<pivot) i++;
            while(i<=j && nums[j]>pivot) j--;
            if(i<=j) swap(nums, i++, j--);
        }
        if(j >= k && left <= k)
            return helper(nums, left, j, k);
        if(i <= k && right >= k)
            return helper(nums, i, right, k);
        return nums[k];
    }
    public int findKthLargest(int[] nums, int k) {
        int res = helper(nums, 0, nums.length-1, nums.length-k);
        return res;
    }
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
