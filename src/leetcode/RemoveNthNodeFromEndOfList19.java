package leetcode;
/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
 */
public class RemoveNthNodeFromEndOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n-- > 0 && fast != null) {
            fast = fast.next;
        }
        ListNode prev = null;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null) {
            head = slow.next;
        } else {
            prev.next = slow.next;

        }
        return head;

    }
}
