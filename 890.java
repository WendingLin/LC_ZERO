class Solution {
    private boolean match(String word, String pattern){
        if(word.length()!=pattern.length()) return false;
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        for(int i = 0; i<word.length(); i++){
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);
            if(!map1.containsKey(c1)) map1.put(c1, c2);
            if(!map2.containsKey(c2)) map2.put(c2, c1);
            
            if(map1.get(c1)!=c2||map2.get(c2)!=c1) return false;
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<String>();
        for(String word : words){
            if(match(word, pattern)) res.add(word);
        }
        return res;
    }
}
