/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode helper(Integer[] nums, int left, int right){
        if(right<left){
            return null;
        }
        int mid = left + (right-left+1)/2;
        TreeNode node = new TreeNode(nums[mid].intValue());
        node.left = helper(nums, left, mid-1);
        node.right = helper(nums, mid+1, right);
        return node;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        List<Integer> nums_list = new ArrayList<Integer>();
        while(head!=null){
            nums_list.add(head.val);
            head = head.next;
        }
        return helper(nums_list.toArray(new Integer[nums_list.size()]), 0, nums_list.size()-1);
    }
}
