class Solution {
    private int m;
    private int n;
    
    private void check(char[][] vec, int i, int j){ 
        if(vec[i][j]=='O'){
			vec[i][j]='1';
			if(i>0)
				check(vec,i-1,j);
			if(j>0)
				check(vec,i,j-1);
			if(i+1<m)
				check(vec,i+1,j);
			if(j+1<n)
				check(vec,i,j+1);
		}
        return;
    }
    public void solve(char[][] board) {
        m = board.length;
        if(m<3) return;
        n = board[0].length;
        if(n<3) return;
		for(int i=0;i<m;i++){
			check(board,i,0);
			check(board,i,n-1);
		}
		for(int j=1;j+1<n;j++){
			check(board,0,j);
			check(board,m-1,j);
		}
        for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(board[i][j]=='O')
					board[i][j]='X';
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(board[i][j]=='1')
					board[i][j]='O';
        return;
    }
}
