class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int last = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<logs.size(); i++){
            String log = logs.get(i);
            String[] info = log.split(":");
            int index = Integer.parseInt(info[0]);
            String type = info[1];
            int pos = Integer.parseInt(info[2]);
            int len = pos-last;
            if(stack.isEmpty()==false) res[stack.peek()] += len;
            last = pos;
            if(type.equals("start")){
                stack.push(index);
            }else{
                res[stack.pop()] ++;
                last++;
            }
        }
        return res;
    }
}
