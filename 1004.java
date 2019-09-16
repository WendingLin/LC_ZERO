class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int res = 0;
        int use = 0;
        while(right<A.length){
            if(A[right++]==1) {
                res = Math.max(res, right-left);
            }
            else{
                if(use<K){
                    res = Math.max(res, right-left);
                    use++;
                }
                else{
                    while(use==K && left!=right){
                        if(A[left++]==0) use--;
                    }
                    use = K;
                }
            }
        }
        return res;
    }
}
