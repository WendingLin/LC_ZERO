class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int level = 1; level<=numRows; level++){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i<level; i++){
                if(i==0 || i==level-1){
                    temp.add(1);
                }else{
                    List<Integer> last = res.get(level-1-1);
                    temp.add(last.get(i-1)+last.get(i));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
