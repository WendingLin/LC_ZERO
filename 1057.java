class Solution {
    class Pair{
        int bike_index;
        int worker_index;
        int dis;
        Pair(int bike_index, int worker_index, int dis){
            this.bike_index = bike_index;
            this.worker_index = worker_index;
            this.dis = dis;
        }
    }
    
    private int calMan(int[] worker, int[] bike){
        return Math.abs(worker[0]-bike[0]) + Math.abs(worker[1]-bike[1]);
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] visited = new boolean[bikes.length];
        PriorityQueue<Pair> pairs = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.dis==p2.dis && p1.worker_index!=p2.worker_index) return p1.worker_index-p2.worker_index;
                else if(p1.dis==p2.dis && p1.bike_index!=p2.bike_index) return p1.bike_index-p2.bike_index;
                else return p1.dis-p2.dis;
            }
        });
        
        for(int i = 0; i<workers.length; i++){
            for(int j = 0; j<bikes.length; j++){
                Pair pair = new Pair(j, i, calMan(workers[i], bikes[j]));
                pairs.offer(pair);
            }
        }
        
        while(pairs.isEmpty()==false){
            Pair pair = pairs.poll();
            if(visited[pair.bike_index] || res[pair.worker_index]!=-1) continue;
            res[pair.worker_index] = pair.bike_index;
            visited[pair.bike_index] = true;
        }
        return res;
                                                        
    }
}
