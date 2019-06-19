/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null)
      return head;
    if (m == n)
      return head;
    int counter = 1;
    ListNode curr = head;
    ListNode prev = null;
    while (counter != m) {
      prev = curr;
      curr = curr.next;
      counter++;
    }

    ListNode newhead = curr;
    ListNode next = curr.next;

    while (counter != n) {
      counter++;
      ListNode tempnext = next.next;
      next.next = curr;
      curr = next;
      next = tempnext;
    }

    if (prev == null)
      head = curr;
    else
      prev.next = curr;

    newhead.next = next;
    return head;
  }
}
