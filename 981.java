class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treemap;
        if(map.containsKey(key)){
            treemap = map.get(key);
        }else{
            treemap = new TreeMap<Integer, String>();
            map.put(key, treemap);
        }
        treemap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(map.containsKey(key)){
            TreeMap<Integer, String> treemap = map.get(key);
            Integer key1 =  treemap.floorKey(timestamp);
            if(key1!=null) res = treemap.get(key1);
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
