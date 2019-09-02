class Solution {
    private boolean helper(int[] data, int i, int j){
        for(int m = i+1; m<j; m++){
            String curr = Integer.toBinaryString(data[m]);
            if(curr.length()!=8 || curr.charAt(0)!='1' || curr.charAt(1)!='0') return false;
        }
        return true;
    }
    public boolean validUtf8(int[] data) {
        if(data==null) return false;  
        for(int i = 0; i<data.length; i++){
            if(data[i]>=256) data[i] -= 256;
        }
        if(data.length == 0) return true;
        int pos = 0;
        while(pos!=data.length){
            if(data[pos]<128) pos++;
            else{
                String start = Integer.toBinaryString(data[pos]);
                int count = 0;
                if(start.length()!=8) return false;
                while(count<8 && start.charAt(count)!='0') count++;
                if(pos+count-1>=data.length || count==1 || count>4) return false;
                if(helper(data, pos, pos+count)==false) return false;
                pos += count;
            }
        }      
        return true;
    }
}
