class Solution {
    private boolean oneDistance(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        boolean diff = false;
        for(int i = 0; i<c1.length; i++){
            if(c1[i]!=c2[i]){
                if(diff==false)
                    diff = true;
                else
                    return false;
            }
        }
        return diff;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        if(wordList.contains(endWord)==false)
            return 0;
        
        int res = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        while(queue.isEmpty()==false){
            int cnt = queue.size();
            for(int i = 0; i<cnt; i++){
                String fake_begin = queue.poll();
                if(fake_begin.equals(endWord))
                    return res;
                for(Iterator<String> iter = wordList.listIterator(); iter.hasNext();){
                    String temp = iter.next();
                    if(oneDistance(fake_begin, temp)==true){
                        queue.add(temp);
                        iter.remove();
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
