class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1set = new HashSet<Integer>();
        Set<Integer> count = new HashSet<Integer>();
        
        for(int num:nums1){
            if(num1set.contains(num)==false)
                num1set.add(num);
        }
        
        for(int num:nums2){
            if(count.contains(num)==false && num1set.contains(num)==true)
                count.add(num);
        }
        int[] res = new int[count.size()];
        int c = 0;
        for(Integer x:count){
            res[c++] = x;
        }
        return res;
    }
}
