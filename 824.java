class Solution {
    private String repeat(int num){
        char[] chars = new char[num];
        Arrays.fill(chars, 'a');
        String text = new String(chars);
        return text;
    }
    public String toGoatLatin(String S) {
        String[] list = S.split(" ");
        String res = "";
        for(int i = 0; i<list.length; i++){
            String s = list[i];
            char first = s.charAt(0);
            if(first=='a'||first=='e'||first=='i'||first=='o'||first=='u'||
              first=='A'||first=='E'||first=='I'||first=='O'||first=='U') s += "ma";
            else s = s.substring(1)+first+"ma";
            if(i==0) res += s + repeat(i+1);
            else res += " "+s+repeat(i+1);
        }
        return res;
    }
}
