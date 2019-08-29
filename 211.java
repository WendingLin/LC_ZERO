class WordDictionary {
    TrieNode root;
    class TrieNode{
        char c;
        boolean hasend = false;
        TrieNode[] children = new TrieNode[26];
        List<Integer> index = new LinkedList<>();
        TrieNode(char c){
            this.c = c;
        }
    }
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null){
                curr.children[index] = new TrieNode(c);
                curr.index.add(index);
                curr = curr.children[index];
            }else{
                curr = curr.children[index];
            }
        }
        curr.hasend = true;
    }
    
    public boolean search(String word, int pos, TrieNode curr){
        if(pos>=word.length()) return curr.hasend;
        char c = word.charAt(pos);
        if(c=='.'){
            if(curr.index.size()==0) return false;
            for(int i = 0; i<curr.index.size(); i++){
                if(search(word, pos+1, curr.children[curr.index.get(i)])==true) return true;
            }
            return false;
        }
        int index = c-'a';
        if(curr.children[index]==null){
            return false;
        }else{
            return search(word, pos+1, curr.children[index]);
        }
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
