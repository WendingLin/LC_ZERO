class Solution {
    private List<String> dfs(String s, HashMap<String, List<String>> map, List<String> wordDict){       
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if(s.equals("")) res.add("");
        else{
            for(String word:wordDict){
                if (word.length()>s.length() || !s.substring(0, word.length()).equals(word)) continue;
                List<String> temp = dfs(s.substring(word.length()), map, wordDict);
                for(int i = 0; i<temp.size(); i++) {
                    String newstr = temp.get(i).equals("") ? word : (word + " " + temp.get(i));
                    res.add(newstr);
                }
            }
        }
        map.put(s, new ArrayList<>(res));
        return res;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        return dfs(s, map, wordDict);
    }
}
