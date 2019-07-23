class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0)
            return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();
        int pos1 = 0, pos2 = 0;
        while(pos1!=nums1.length && pos2!=nums2.length){
            if(nums1[pos1]<nums2[pos2])
                pos1++;
            else if(nums1[pos1]==nums2[pos2]){
                list.add(nums1[pos1]);
                pos1++;
                pos2++;
            }else
                pos2++;
        }
        int[] res = new int[list.size()];
        ListIterator<Integer> listIterator = list.listIterator();
        int count = 0;
	    while (listIterator.hasNext()) {
			res[count++] = listIterator.next();
		}
        return res;
    }
}
