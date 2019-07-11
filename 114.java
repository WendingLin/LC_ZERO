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
    private List<TreeNode> res = new ArrayList<>();
    private void preOrder(TreeNode root){
	if(root==null)
	    return;
	res.add(root);
	preOrder(root.left);
	preOrder(root.right);
    }
    public void flatten(TreeNode root) {
	if(root==null)
	    return;
	preOrder(root);
	for(int i = 0; i<res.size()-1; i++){
	    res.get(i).right = res.get(i+1);
	    res.get(i).left = null;
	}
	res.get(res.size()-1).right = null;
	res.get(res.size()-1).left = null;
	return;
    }
}
