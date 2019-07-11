class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length==0)
            return true;
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for(int p:preorder){
            if(p<low)
                return false;
            while(!stack.isEmpty() && p>stack.peek())
                low = stack.pop();
            stack.push(p);
        }
        return true;
    }
}
