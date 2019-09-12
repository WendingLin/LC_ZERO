class Solution {
    public int minAddToMakeValid(String S) {
        if(S.length()==0) return 0;
        Stack<Character> stack = new Stack<>();
        
        int res = 0;
        for(int i = 0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c=='(') stack.push('(');
            else{
                if(stack.isEmpty()) res++;
                else stack.pop();
            }
        }
        
        return res + stack.size();
    }
}
