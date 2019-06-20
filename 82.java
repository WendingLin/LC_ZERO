/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null)
      return head;
    ListNode fakehead = new ListNode(-1);
    fakehead.next = head;

    ListNode curr = fakehead;
    while (curr.next != null) {
      ListNode nextlist = curr.next;
      while (nextlist.next != null && nextlist.val == nextlist.next.val) {
        nextlist = nextlist.next;
      }
      if (nextlist == curr.next) {
        curr = curr.next;
      } else {
        curr.next = nextlist.next;
      }
    }
    return fakehead.next;
  }
}
