class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int end = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            int start = intervals[i][0];
            if(start<end)
                return false;
            end = intervals[i][1];
        }
        return true;
    }
}
