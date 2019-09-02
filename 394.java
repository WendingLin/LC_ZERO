class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> numstack =new Stack<>();
        Stack<String> strstack = new Stack<>();
        String res = "";
        String curr = "";
        int val = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)==true){
                val = val*10+c-'0';
            }else if(c=='['){
                numstack.push(val);
                strstack.push(curr);
                val = 0;
                curr = "";
            }else if(c==']'){
                int repeat = numstack.pop();
                String newstr = new String(curr);
                for(int j = 1; j<repeat; j++){
                    newstr += curr;
                }
                if(strstack.isEmpty()==false) newstr = strstack.pop() + newstr;
                curr = newstr;
            }else{
                curr += c;
            }
        }
        return curr;
    }
}
