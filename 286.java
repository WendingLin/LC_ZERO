class Solution {
    private int m;
    private int n;
    private void traverse(int[][] rooms, int i, int j, int dis){
        if(i<0 || j<0 || i>=m || j>=n || rooms[i][j] ==-1 || rooms[i][j] < dis) return;
        rooms[i][j] = Math.min(dis, rooms[i][j]);
        traverse(rooms, i-1, j, rooms[i][j]+1);
        traverse(rooms, i+1, j, rooms[i][j]+1);
        traverse(rooms, i, j-1, rooms[i][j]+1);
        traverse(rooms, i, j+1, rooms[i][j]+1);
    }
    public void wallsAndGates(int[][] rooms) {
        m = rooms.length;
        if(m==0) return;
        n = rooms[0].length;
        if(n==0) return;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(rooms[i][j]==0)
                    traverse(rooms, i, j, 0);
            }
        }
        return;
    }
}
