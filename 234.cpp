// 快慢指针
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
    if (head == NULL)
      return true;
    stack<int> node_stack;
    ListNode *slow = head;
    ListNode *fast = head;
    while (fast->next && fast->next->next) {
      fast = fast->next->next;
      node_stack.push(slow->val);
      slow = slow->next;
    }

    // even
    if (fast->next)
      node_stack.push(slow->val);
    slow = slow->next;

    while (!node_stack.empty()) {
      if (node_stack.top() != slow->val)
        return false;
      node_stack.pop();
      slow = slow->next;
    }
    return true;
  }
};
