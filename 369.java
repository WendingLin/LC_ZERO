/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode plusOne(ListNode head) {
    Stack<ListNode> node = new Stack<ListNode>();
    ListNode curr = head;

    while (curr.next != null) {
      node.push(curr);
      curr = curr.next;
    }

    if (curr.val != 9) {
      curr.val++;
      return head;
    } else {
      curr.val = 0;
      while (node.empty() == false && node.peek().val == 9) {
        node.pop().val = 0;
      }
      if (node.empty() == true) {
        ListNode newhead = new ListNode(1);
        newhead.next = head;
        return newhead;
      } else {
        node.pop().val++;
        return head;
      }
    }
  }
}
