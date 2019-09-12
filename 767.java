class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[256];
        PriorityQueue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2){
                return count[c2]-count[c1];
            }
        });
        
        for(char c:S.toCharArray()) count[c]++;
        
        for(int i = 0; i<256; i++){
            if(count[i]>(S.length()+1)/2) return "";
            if(count[i]>0) pq.offer((char)i);
        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<S.length(); i++){
            char c = pq.poll();
            if(i>0 && c == res.charAt(i-1)){
                if(pq.isEmpty()) return "";
                else{
                    char oc  = pq.poll();
                    res.append(oc);
                    if(--count[oc]>0) pq.offer(oc);
                }
                pq.offer(c);
            }else{
                res.append(c);
                if(--count[c]>0) pq.offer(c);
            }
        }
        
        return res.toString();                
    }
}
