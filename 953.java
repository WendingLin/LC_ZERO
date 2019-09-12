class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dic = new int[26];
        for(int i = 0; i<order.length(); i++){
            char c = order.charAt(i);
            dic[c-'a'] = i;
        }
        
        for(int i = 0; i<words.length-1; i++){
            String curr = words[i];
            String next = words[i+1];
            boolean ok = false;
            for(int j = 0; j<Math.min(curr.length(), next.length()); j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if(dic[c1-'a']<dic[c2-'a']){
                    ok = true;
                    break;
                }
                else if(dic[c1-'a']>dic[c2-'a']) return false;
                else continue;
            }
            if(ok==false && curr.length()>next.length()) return false;
        }
        return true;
    }
}
