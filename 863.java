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
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();
    private void DFS(TreeNode curr, TreeNode parent){
        if(curr==null) return;
        map.put(curr, parent);
        DFS(curr.left, curr);
        DFS(curr.right, curr);
    }
    
    private void traverse(TreeNode curr, int K,  List<Integer> res){
        if(curr==null || visited.contains(curr)) return;
        visited.add(curr);
        if(K==0){
            res.add(curr.val);
            return;
        }
        traverse(curr.left, K-1, res);
        traverse(curr.right, K-1, res);
        traverse(map.get(curr), K-1, res);
        return;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        DFS(root, null);
        List<Integer> res = new ArrayList<Integer>();
        traverse(target, K, res);
        return res;
 
    }
}
