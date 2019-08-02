class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0) return res;
        
        int leftvertical = 0, rightvertical = matrix[0].length-1;
        int uphori = 0, downhori = matrix.length-1;
        while(leftvertical<=rightvertical && uphori<=downhori){
            for(int i = leftvertical; i<=rightvertical; i++){
                res.add(matrix[uphori][i]);
            }
            for(int i = uphori+1; i<downhori; i++){
                res.add(matrix[i][rightvertical]);
            }
            if(uphori!=downhori){
                for(int i = rightvertical; i>=leftvertical; i--){
                    res.add(matrix[downhori][i]);
                }
            }
            if(leftvertical!=rightvertical){
                for(int i = downhori-1; i>uphori; i--){
                    res.add(matrix[i][leftvertical]);
                }
            }
            leftvertical++;
            rightvertical--;
            uphori++;
            downhori--;
        }
        return res;
    }
}
