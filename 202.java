class Solution {
    private HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if(n==1)
            return true;
        if(set.contains(n)==true)
                return false;
            else
                set.add(n);
        String split = String.valueOf(n);
        int newval = 0;
        for(int i = 0; i<split.length(); i++){
            char c= split.charAt(i);
            int val = (int)c-(int)('0');
            newval += val*val;

        }
        return isHappy(newval);
    }
}
