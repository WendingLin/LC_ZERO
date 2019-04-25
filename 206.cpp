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
  ListNode *reverseList(ListNode *head) {
    ListNode *prev = NULL;
    ListNode *curr = head;
    while (curr) {
      ListNode *temp_next = curr->next;
      curr->next = prev;
      prev = curr;
      curr = temp_next;
    }
    return prev;
  }
};
