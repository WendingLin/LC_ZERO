class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m-1;
        int pos2 = n-1;
        int pos = m+n-1;
        
        while(pos2>=0 && pos1>=0){
            if(nums2[pos2]>nums1[pos1])
                nums1[pos--] = nums2[pos2--];
            else
                nums1[pos--] = nums1[pos1--];
        }
        while(pos2>=0)
            nums1[pos--] = nums2[pos2--];
        while(pos1>=0)
            nums1[pos--] = nums1[pos1--];
        
    }
}
