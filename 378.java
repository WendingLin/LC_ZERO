class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(k==1) return matrix[0][0];
        int n = matrix.length;
        if(k==n*n) return matrix[n-1][n-1];

        Queue<Num> queue = new PriorityQueue<Num>();
        for(int i = 0; i<n; i++)
            queue.add(new Num(0, i, matrix[0][i]));
        int count = 1;
        while(count++!=k){
            Num num = queue.poll();
            if(num.posx==n-1) continue;
            queue.add(new Num(num.posx+1, num.posy, matrix[num.posx+1][num.posy]));
        }
        return queue.poll().val;
    }
    class Num implements Comparable<Num>{
        public int posx;
        public int posy;
        public int val;
        public Num(int posx, int posy, int val){
            this.posx = posx;
            this.posy = posy;
            this.val = val;
        }
        @Override
        public int compareTo (Num that) {
            return this.val - that.val;
        }
    }
}
