class LFUCache {
    class Cache{
        int key;
        int val;
        int freq;
        Cache(int key, int val, int freq){
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
    HashMap<Integer, Cache> map;
    HashMap<Integer, LinkedList<Cache>> levels;
    int size;
    int capacity;
    int leastlevel;
    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.levels = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.leastlevel=-1;
    }
    
    private void rearrange(int key){
        Cache cache = map.get(key);
        LinkedList<Cache> currlevel = levels.get(cache.freq); 
        currlevel.remove(cache);
        if(currlevel.size()==0 && leastlevel==cache.freq) leastlevel++;
        
        cache.freq++;
        
        if(levels.containsKey(cache.freq)==false) levels.put(cache.freq, new LinkedList<Cache>());
        LinkedList<Cache> nextlevel = levels.get(cache.freq);
        nextlevel.add(cache);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            rearrange(key);
            return map.get(key).val;
        } 
        else return -1;
    }
    
    private void evict(){
        LinkedList<Cache> least = levels.get(leastlevel);
        Cache removed = least.removeFirst();
        map.remove(removed.key);
        size--;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Cache cache = map.get(key);
            cache.val = value;
            map.put(key, cache);
            rearrange(key);
            return;
        }
        else if(capacity==0) return;
        if(size==capacity) evict();
        Cache cache = new Cache(key, value, 1);
        map.put(key, cache);
        if(leastlevel==-1) levels.put(1, new LinkedList<Cache>());
        LinkedList<Cache> level = levels.get(1);
        level.add(cache);
        leastlevel=1;
        size++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
