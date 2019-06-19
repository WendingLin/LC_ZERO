/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeElements(ListNode head, int val) {

    ListNode curr = head;
    ListNode prev = null;

    while (curr != null) {
      if (curr.val == val) {
        if (prev == null) {
          head = curr.next;
          curr = head;
        } else {
          prev.next = curr.next;
          curr = curr.next;
        }
      } else {
        prev = curr;
        curr = curr.next;
      }
    }

    return head;
  }
}
