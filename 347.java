class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)) map.put(num, map.get(num)+1);
            else map.put(num, 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer s1, Integer s2){
                return map.get(s2)-map.get(s1);
            }
        });
        
        for (Integer key : map.keySet()) {
            pq.offer(key);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i<k; i++)
            res.add(pq.poll());
        return res;
    }
}
