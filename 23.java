/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    ListNode head = new ListNode(0);
    ListNode iter = head;

    PriorityQueue<ListNode> pq =
        new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);

    for (ListNode list : lists) {
      if (list != null)
        pq.add(list);
    }

    while (pq.isEmpty() != true) {
      ListNode curr = pq.poll();
      iter.next = curr;
      iter = curr;
      if (curr.next != null) {
        pq.add(curr.next);
      }
    }

    return head.next;
  }
}
