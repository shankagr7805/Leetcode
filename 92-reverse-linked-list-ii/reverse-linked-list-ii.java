class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode temp = prev.next;
        ListNode next = null;

        for (int i = 0; i < right - left; i++) {
            next = temp.next;
            temp.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}