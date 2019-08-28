class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if(words==null || words.length==0) return new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String word:words){
            if(count.containsKey(word))
                count.put(word, count.get(word)+1);
            else
                count.put(word, 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return count.get(s2)-count.get(s1) == 0?s1.compareTo(s2):count.get(s2)-count.get(s1);
            }
        });
        for (String key : count.keySet()) {
             pq.add(key);
        }
        for(int i = 0; i<k; i++){
            res.add(pq.poll());
        }
        return res;
    }
}
