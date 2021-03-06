/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int counter = 0;
    ListNode fast = head;
    ListNode slow = head;

    while (counter != n) {
      fast = fast.next;
      counter++;
    }
    if (fast == null) {
      head = head.next;
      return head;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;
  }
}
