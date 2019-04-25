// recursion
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
  bool isPalindrome(ListNode *head) {
    ref = head;
    return recursionHelper(head);
  }

private:
  ListNode *ref;
  bool recursionHelper(ListNode *curr);
};

bool Solution::recursionHelper(ListNode *curr) {
  if (curr == NULL)
    return true;
  if (recursionHelper(curr->next) == false)
    return false;
  bool curr_result = (ref->val == curr->val) ? true : false;
  ref = ref->next;
  return curr_result;
}
