class Solution {
    
    private int getRes(String s2, String s1, String symbol){
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        if(symbol.equals("+"))
            return i1+i2;
        else if(symbol.equals("-"))
            return i1-i2;
        else if(symbol.equals("*"))
            return i1*i2;
        return i1/i2;
    }
    
    public int evalRPN(String[] tokens) {
        if(tokens.length==0)
            return 0;
        Stack<String> stack = new Stack<>();
        for(String token:tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int res = getRes(stack.pop(), stack.pop(), token);
                stack.push(String.valueOf(res));
            }else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
