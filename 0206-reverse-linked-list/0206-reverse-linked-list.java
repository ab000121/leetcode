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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode rev = new ListNode(head.val , null);
        head = head.next;
        ListNode newHead = rev;

        while(head != null){
            ListNode newNode = new ListNode(head.val , newHead);
            newHead = newNode;
            head = head.next;
        }

        return newHead;
    }
}