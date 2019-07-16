class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int pos = 1, size = path.length();
        while(pos<size){
            String temp = "";
            while(pos<size && path.charAt(pos)=='/'){
                pos++;
            }
            while(pos<size && path.charAt(pos)!='/'){
                temp += path.charAt(pos++);
            }
            pos++;
            if(temp.equals("."))
                continue;
            else if(temp.equals("..")){
                if(stack.size()>0) stack.pop();
                continue;
            }else if(temp.equals("")){
                continue;
            }else{
                stack.push(temp);
            }
        }
        if(stack.isEmpty()==true)
            return "/";
        String res = "";
        while(stack.size()>0){
            res = "/" + stack.pop()+res;
        }
        return res;
    }
}
