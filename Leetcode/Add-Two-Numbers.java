/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode ans = setListNode(l1, l2, new ListNode(), false);
    // while (ans.next != null) System.out.println(ans.val);

    return ans;
  }

  public ListNode setListNode(ListNode l1, ListNode l2, ListNode node, boolean isUpper) {
    if (l1 == null) l1 = new ListNode();
    if (l2 == null) l2 = new ListNode();
    System.out.println(l1.val + " " + l2.val + " " + isUpper);
    boolean tmp = (l1.val + l2.val + (isUpper ? 1 : 0)) >= 10;
    node.val = (l1.val + l2.val + (isUpper ? 1 : 0)) % 10;
    if (l1.next == null && l2.next == null) {
      if (tmp) {
        node.next = new ListNode(1);
      }
      return node;
    }
    node.next = setListNode(l1.next, l2.next, new ListNode(), tmp);

    return node;
  }
}