class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ","");
        Stack<Integer> stack =new Stack<>();
        int num = 0;
        char last = '+';
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)==true) num = num*10 + c-'0';
            if(Character.isDigit(c)==false || i==s.length()-1){
                if(last=='+'){
                    stack.push(num);
                }else if(last=='-'){
                    stack.push(-num);
                }else if(last=='*'){
                    int lastnum = stack.pop();
                    stack.push(lastnum*num);
                }else{
                    int lastnum = stack.pop();
                    stack.push(lastnum/num);
                }
                last = c;
                num = 0;
            }
        }
        int res = 0;
        while(stack.isEmpty()==false){
            res += stack.pop();
        }
        return res;
    }
}
