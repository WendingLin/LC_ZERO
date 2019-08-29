class Solution {
    boolean DFS(List<List<Integer>> path, boolean[] marked, int pos){
        if(marked[pos]==true) return false;
        marked[pos] = true;
        for(int i = 0; i<path.get(pos).size(); i++){
            if(DFS(path, marked, path.get(pos).get(i))==false) return false;
        }
        marked[pos] = false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        for(int i = 0; i<numCourses; i++) path.add(new ArrayList<Integer>());
        for(int[] pre:prerequisites){
            path.get(pre[0]).add(pre[1]);
        }
        boolean[] marked = new boolean[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(DFS(path, marked, i)==false) return false;
        }
        return true;
    }
}
