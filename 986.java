class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int indexa = 0;
        int indexb = 0;
        
        List<int[]> list = new LinkedList<>();
        while(indexa<A.length && indexb<B.length){
            int al = A[indexa][0], ar = A[indexa][1];
            int bl = B[indexb][0], br = B[indexb][1];
            
            int start = Math.max(al, bl);
            int end = Math.min(ar, br);
            if(start<=end){
                int[] scan = new int[2];
                scan[0] = start;
                scan[1] = end;
                list.add(scan);
            }
            if(br==end) indexb++;
            if(ar==end) indexa++;
        }
        
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
        return res;
    }
}
