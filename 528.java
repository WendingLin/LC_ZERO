class Solution {

    int[] presum;
    Random ran;
    
    private int getindex(int target){
        int left = 0;
        int right = presum.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(presum[mid]==target) return mid;
            else if(presum[mid]>target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    public Solution(int[] w) {
        presum = new int[w.length];
        ran = new Random();
        int sum = 0;
        for(int i = 0; i<w.length; i++){
            sum += w[i];
            presum[i] = sum;
        }
    }
    
    public int pickIndex() {
        int rand = ran.nextInt(presum[presum.length-1]) + 1;
        return getindex(rand);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
