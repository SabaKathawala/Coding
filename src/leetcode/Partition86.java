package leetcode;

public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = head;
        while(end.next != null) {
            end = end.next;
        }
        ListNode front = head;
//        if(head.val >= x) {
//            front = dummy;
//        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode back = end;
        while(curr != null) {
            ListNode next = curr.next;
            if(curr.val < x) {
                if(prev != null) {
                    prev.next = curr.next;
                    curr.next = front.next;
                    front.next = curr;
                    front = curr;
                    curr = next;
                } else {
                    prev = curr;
                    curr = next;
                }
            } else {
                prev = curr;
                curr = next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);

        new Partition86().partition(list, 4);
    }
}