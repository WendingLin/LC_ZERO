/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null)
      return head;

    ListNode newhead = new ListNode(0);
    ListNode iter = newhead; // new list range
    iter.next = head;

    ListNode curr = head; // scan iter

    while (curr != null) {
      ListNode next = curr.next;
      ListNode initer = newhead;
      boolean flag = false;

      while (initer.next != curr) {
        ListNode comp = initer.next;
        if (comp.val > curr.val) {
          curr.next = comp;
          initer.next = curr;
          flag = true;
          break;
        }
        initer = initer.next;
      }
      if (flag == true) {
        iter.next = next;
      } else {
        iter = iter.next;
      }
      curr = next;
    }

    return newhead.next;
  }
}
