class Solution {
    private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private void backTracking(String digits, int pos, List<String> res, String temp){
        if(temp.length()==digits.length()){
            res.add(new String(temp));
            return;
        }
        int num = Character.getNumericValue(digits.charAt(pos));
        String enumstr = mapping[num];
        for(int i = 0; i<enumstr.length(); i++){
            temp = temp + String.valueOf(enumstr.charAt(i));
            backTracking(digits, pos+1, res, temp);
            temp = temp.substring(0, temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.equals("")) return res;
        backTracking(digits, 0 , res, new String());
        return res;
    }
}
