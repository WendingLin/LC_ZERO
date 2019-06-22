/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode right = head, mid = head, left = head;
    while (right.next != null) {
      right = right.next;
      if (right.next != null) {
        right = right.next;
        mid = mid.next;
      }
    }

    right = mid.next;
    mid.next = null;

    left = sortList(left);
    right = sortList(right);

    ListNode newhead = new ListNode(0);
    ListNode iter = newhead;

    while (left != null && right != null) {
      if (left.val > right.val) {
        iter.next = right;
        right = right.next;
        iter = iter.next;
      } else {
        iter.next = left;
        left = left.next;
        iter = iter.next;
      }
    }

    if (left != null) {
      while (left != null) {
        iter.next = left;
        left = left.next;
        iter = iter.next;
      }

    } else if (right != null) {
      while (right != null) {
        iter.next = right;
        right = right.next;
        iter = iter.next;
      }
    }

    return newhead.next;
  }
}
