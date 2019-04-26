// Remember to split
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
  void reorderList(ListNode *head) {
    if (head == NULL)
      return;
    ListNode *slow = head;
    ListNode *fast = head;
    while (fast->next && fast->next->next) {
      slow = slow->next;
      fast = fast->next->next;
    }
    ListNode *prev = NULL;
    ListNode *curr = slow->next;
    slow->next = NULL;
    while (curr) {
      ListNode *temp = curr->next;
      curr->next = prev;
      prev = curr;
      curr = temp;
    }
    ListNode *list1_curr = head;
    ListNode *list2_curr = prev;
    while (list2_curr) {
      ListNode *temp_1 = list1_curr->next;
      ListNode *temp_2 = list2_curr->next;
      list1_curr->next = list2_curr;
      if (temp_1)
        list2_curr->next = temp_1;
      list1_curr = temp_1;
      list2_curr = temp_2;
    }
    return;
  }
};
