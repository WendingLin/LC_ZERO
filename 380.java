class RandomizedSet {
    HashMap<Integer, Integer> val_pos;
    List<Integer> list;
     java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        val_pos = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(val_pos.containsKey(val)) return false;
        val_pos.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(val_pos.containsKey(val)==false) return false;
        int curr_pos = val_pos.get(val);
        list.set(curr_pos, list.get(list.size()-1));
        val_pos.put(list.get(list.size()-1), curr_pos);
        val_pos.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
