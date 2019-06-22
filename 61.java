/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null)
      return head;

    int counter = 0;
    ListNode fast = head, slow = head;

    while (counter != k) {
      counter++;
      fast = fast.next;
      if (fast == null) {
        fast = head;
        k = k % counter;
        counter = 0;
      }
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    fast.next = head;
    head = slow.next;
    slow.next = null;

    return head;
  }
}
