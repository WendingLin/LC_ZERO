class Solution {
    private String combine(String left){
        if(left.length()>0 && Character.isDigit(left.charAt(left.length()-1))){
            int val = Character.getNumericValue(left.charAt(left.length()-1));
            left = left.substring(0, left.length()-1) + String.valueOf(val+1);
            return left;
        }
        left = left + String.valueOf(1);
        return left;
    }
    private void backTracking(List<String> res, String word, String temp, int pos){
        if(pos==word.length()){
            res.add(new String(temp));
            return;
        }
        String copy = new String(temp); //num
        char c = word.charAt(pos);
        temp = temp+String.valueOf(c);
        backTracking(res, word, temp, pos+1);
        copy = combine(copy);
        backTracking(res, word, copy, pos+1);
    }
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if(word==null) return res;
        backTracking(res, word, new String(), 0);
        return res;
    }
}
