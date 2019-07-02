/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
private:
  int res = -2147483648;
  void helper(TreeNode *root, int &sin, int &dou) {
    if (root == NULL) {
      sin = 0;
      dou = 0;
      return;
    }

    helper(root->left, sin, dou);
    int leftsingle = sin;
    int leftdouble = dou;

    helper(root->right, sin, dou);
    int rightsingle = sin;
    int rightdouble = dou;

    dou = leftsingle + rightsingle + root->val;
    dou = max(dou, root->val);
    sin = max(leftsingle, rightsingle) + root->val;
    sin = max(sin, root->val);

    int curr = max(dou, sin);
    res = max(curr, res);
  }

public:
  int maxPathSum(TreeNode *root) {
    int sin = 0;
    int dou = 0;
    helper(root, sin, dou);
    return res;
  }
};
