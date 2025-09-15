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
    private ListNode middle(ListNode head) {
        ListNode slow = head , fast = head.next ;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode l1 , ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode prev = temp;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1 ;
                l1 = l1.next ;
            } else {
                prev.next = l2 ;
                l2 = l2.next ;
            }
            prev = prev.next ;
        }
        if(l1 != null) prev.next = l1 ;
        if(l2 != null) prev.next = l2 ;

        return temp.next ;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = middle(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode left_sort = sortList(head);
        ListNode right_sort = sortList(right);

        return merge(left_sort , right_sort);
    }
}