func twoSum(nums []int, target int) []int {
    var ans = []int{0,0}
    var dict map[int]int
    dict = make(map[int]int)
    var length = len(nums)
    
    for a:=0; a<length; a++{
        if _, exists:= dict[nums[a]]; exists{
            ans[0]=dict[nums[a]]
            ans[1]=a
            break
        }
        dict[target-nums[a]]=a
    }
    return ans
}