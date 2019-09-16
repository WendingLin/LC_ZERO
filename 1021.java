class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        String res = "";
        for(int i = 0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c=='(') stack.push(i);
            else{
                if(stack.size()==2) res += S.substring(stack.pop(),i+1);
                else stack.pop();
            }
        }
        return res;
    }
}
