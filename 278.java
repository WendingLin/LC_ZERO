/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = (right-left)/2+left;
        while(left<right){
            mid = (right-left)/2+left;
            if(isBadVersion(mid)==true){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
