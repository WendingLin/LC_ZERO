class Solution {
    private int res = 0;
    public int lengthLongestPath(String input) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        int lastlevel = 0;
        int size = input.length();
        while(pos<size){
            int currlevel = 0;
            boolean file = false;
            while(pos<size && input.charAt(pos)=='\t'){
                currlevel++;
                pos++;
            }
            int start = pos;
            if(currlevel==lastlevel){
                if(stack.isEmpty()==false){
                    count -= stack.pop();
                }
            }
            else if(currlevel<lastlevel){
                for(int i = 0; i<=lastlevel-currlevel; i++){
                    count -= stack.pop();
                }
            }

            lastlevel = currlevel;
            while(pos<size && input.charAt(pos)!='\n'){
                if(input.charAt(pos)=='.')
                    file=true;
                pos++;
            }

            int length = pos - start + 1;
            count += length;
            if(file==true)
                res = Math.max(count-1, res);
            stack.push(length);
            pos++;
        }
        return res;
    }
}
