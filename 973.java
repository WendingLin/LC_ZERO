class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] s1, int[] s2){
                int p1 = s1[0]*s1[0]+s1[1]*s1[1];
                int p2 = s2[0]*s2[0]+s2[1]*s2[1];
                return p1-p2;
            }
        });
        for(int[] point:points){
            pq.offer(point);
        }

        int[][] res = new int[K][2];
        for(int i = 0; i<K; i++) res[i] = pq.poll();

        return res;
    }
}
