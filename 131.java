class Solution {
    private boolean isPalindrome(String s, int st, int e){
        int start = st;
        int end = e;
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
    
    private void helper(String s, int start, List<String> temp, List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i)==false) continue;
            temp.add(s.substring(start, i+1));
            helper(s, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
        return;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if(s==null || s.length()==0) return res;
        helper(s, 0, temp, res);
        return res;
    }
}
