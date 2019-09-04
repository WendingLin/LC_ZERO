class Solution {
    public boolean checkVFNum(String num){
        return num.length()<4 && (num.matches("([1-9])([0-9])*") || num.equals("0"));
    }
    public boolean checkVSNum(String num){
        return num.length()<5 && (num.matches("([0-9]|[a-f]|[A-F])+"));
    }
    
    private boolean checkVF(String IP){
        if(IP.charAt(IP.length()-1)=='.') return false;
        String[] arr = IP.split("\\.");
        if(arr.length!=4) return false;
        for(String s:arr){
            if(checkVFNum(s)==false) return false;
            int val = Integer.parseInt(s);
            if(val<0||val>255) return false;
        }
        return true;
    }
    
    private boolean checkVS(String IP){
        if(IP.charAt(IP.length()-1)==':') return false;
        String[] arr = IP.split(":");
        if(arr.length!=8) return false;
        for(String s:arr){
            if(checkVSNum(s)==false) return false;
        }
        return true;
    }
    
    public String validIPAddress(String IP) {
        if(IP.indexOf(":")>=0){
            return checkVS(IP)?"IPv6":"Neither";
        }else if(IP.indexOf(".")>=0){
            return checkVF(IP)?"IPv4":"Neither";
        }
        return "Neither";

    }
}
