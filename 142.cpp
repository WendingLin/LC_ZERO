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
  ListNode *detectCycle(ListNode *head) {
    if (head == NULL)
      return NULL;
    ListNode *fast = head;
    ListNode *slow = head;
    bool find = false;
    while (fast->next && fast->next->next) {
      slow = slow->next;
      fast = fast->next->next;
      if (slow == fast) {
        find = true;
        break;
      }
    }
    if (find) {
      ListNode *slow2 = head;
      while (slow2 != slow) {
        slow = slow->next;
        slow2 = slow2->next;
      }
      return slow;
    } else {
      return NULL;
    }
  }
};
