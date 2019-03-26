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
  ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    int length_a = getLength(headA);
    int length_b = getLength(headB);
    int div = 0;
    if (length_a > length_b) {
      moveHead(&headA, length_a - length_b);
    } else {
      moveHead(&headB, length_b - length_a);
    }
    for (auto i = 0; i < length_b; i++) {
      if (headA == headB)
        return headA;
      else {
        headA = headA->next;
        headB = headB->next;
      }
    }
    return NULL;
  }

private:
  int getLength(ListNode *head) {
    int length = 0;
    while (head) {
      length++;
      head = head->next;
    }
    return length;
  }

  void moveHead(ListNode **head, int move_times) {
    for (auto i = 0; i < move_times; i++) {
      *head = (*head)->next;
    }
  }
};
