/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
    if (head == null)
      return head;

    ListNode largehead = new ListNode(0);
    ListNode smallhead = new ListNode(0);

    ListNode largeiter = largehead, smalliter = smallhead;

    ListNode prev = new ListNode(0);
    prev.next = head;

    while (prev.next != null) {
      ListNode curr = prev.next;
      if (curr.val < x) {
        smalliter.next = curr;
        smalliter = smalliter.next;
      } else {
        largeiter.next = curr;
        largeiter = largeiter.next;
      }
      prev = prev.next;
    }

    smalliter.next = largehead.next;
    largeiter.next = null;
    return smallhead.next;
  }
}
