package leetcode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ListNode current = lists[0];
        for(int i=1; i< lists.length; i++) {
            ListNode next = lists[i];
            current = merge(current, next);
        }
        return current;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode headL1 = l1;
        ListNode headL2 = l2;
        ListNode currentL1 = headL1;
        ListNode prevL1 = currentL1;
        while(currentL1 != null && headL2 != null) {
            if(currentL1.val == headL2.val) {
                ListNode nextL1 = currentL1.next;
                currentL1.next = headL2;
                headL2 = headL2.next;
                currentL1.next.next = nextL1;
                prevL1 = currentL1;
                currentL1 = currentL1.next;
            }
            else if(currentL1.val > headL2.val) {
                prevL1.next = headL2;
                headL2 = headL2.next;
                prevL1.next.next = currentL1;
            } else {
                prevL1 = currentL1;
                currentL1 = currentL1.next;
            }
        }
        if(currentL1 == null && headL2 != null) {
            prevL1.next = headL2;
        }
        return headL1;
    }

    public static void main(String[] args) {

    }
}
