/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null)
      return head;

    int counter = 0;
    ListNode curr = head;
    ListNode prev = null;

    while (counter != k) {
      if (curr == null)
        return head;
      curr = curr.next;
      counter++;
    }

    curr = head;
    counter = 0;

    while (counter != k) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      counter++;
    }

    head.next = reverseKGroup(curr, k);
    return prev;
  }
}
