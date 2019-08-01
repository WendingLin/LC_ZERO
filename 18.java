class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<4) return res;
        Arrays.sort(nums);
        for(int j = 0; j<nums.length-3; j++){
            if(j>0 && nums[j]==nums[j-1]) continue;
            for(int i = j+1; i<nums.length-2; i++){
                if(i>j+1 && nums[i]==nums[i-1]) continue;
                int starget = target-nums[i]-nums[j];
                int left = i+1;
                int right = nums.length-1; 
                while(left<right){
                    int sum  = nums[left] + nums[right];
                    if(sum>starget) right--;
                    else if(sum<starget) left++;
                    else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[j]);
                        temp.add(nums[i]);
                        temp.add(nums[left++]);
                        temp.add(nums[right--]);
                        res.add(temp);
                        while(left<right && nums[left]==nums[left-1]) left++;
                        while(right>left && nums[right]==nums[right+1]) right--;
                    }
                }
            }
        }
        return res;        
    }
}
