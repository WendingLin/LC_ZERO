class Solution {
    private String intarrtostr(int[] visited){
        StringBuilder sb = new StringBuilder();
        for(int i:visited) sb.append(i);
        return sb.toString();
    }
    private boolean match(int zero, int[] temp, int way, HashSet<String> visited, Queue<int[]> q, int[] target){
        int[] right = temp.clone();
        right[zero] = right[zero+way];
        right[zero+way] = 0;
        if(Arrays.equals(right, target)) return true;
        else if(visited.contains(intarrtostr(right))==false) {
            visited.add(intarrtostr(right));
            q.offer(right);
        }
        return false;
    }
    public int slidingPuzzle(int[][] board) {
        int res = 0;
        int[] target = new int[]{1,2,3,4,5,0}; 
        HashSet<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int[] origin = new int[6];
        for(int i = 0; i<2; i++){
            for(int j=0; j<3; j++){
                origin[3*i+j] = board[i][j];
            }
        }
        if(Arrays.equals(origin, target)) return 0;
        q.offer(origin);
        visited.add(intarrtostr(origin));
        while(q.isEmpty()==false){
            res++;
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] temp = q.poll();
                int zero = 0;
                for(zero = 0; zero<6; zero++)
                    if(temp[zero]==0) break;
                if(zero!=5 && zero!=2){
                    if(match(zero, temp, 1, visited, q, target)) return res;
                }
                if(zero!=0 && zero!=3){
                    if(match(zero, temp, -1, visited, q, target)) return res;
                }
                if(zero-3>=0){
                    if(match(zero, temp, -3, visited, q, target)) return res;
                }
                if(zero+3<6){
                    if(match(zero, temp, 3, visited, q, target)) return res;
                }
            }
        }
        return -1;
    }
}
