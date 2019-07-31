class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0]-i2[0];
            }
        });
        
        List<int[]> res = new ArrayList<int[]>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 0; i<intervals.length; i++){
            int newstart = intervals[i][0];
            int newend = intervals[i][1];
            if(newstart<=end){
                end = newend>=end?newend:end;
            }else{
                res.add(new int[]{start, end});
                start = newstart;
                end = newend;
            }
        }
        res.add(new int[]{start, end});
        int[][] arrres = new int[res.size()][];
        for(int i = 0; i<res.size(); i++){
            arrres[i] = res.get(i);
        }
        return arrres;
    }
}
