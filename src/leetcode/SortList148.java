package leetcode;

public class SortList148  {
    public ListNode sortList(ListNode head) {
            //ListNode start = head;
        if(head.next == null) {
            return head;
        }
        ListNode mid = head;
        ListNode last = head.next;
        while(last.next != null) {
            mid = mid.next;
            last = last.next;
            if(last.next != null) {
                last = last.next;
            }
        }
        ListNode nextToMid = mid.next;
        mid.next = null;
        head = sortList(head);
        nextToMid = sortList(nextToMid);
        ListNode root = head;
        ListNode pre = null;
        while(head != null && nextToMid != null) {
            if(head.val > nextToMid.val) {
                ListNode first = head;
                head = nextToMid;
                if(pre == null) {
                    root = head;
                } else {
                    pre.next = head;
                }
                pre = head;
                nextToMid = nextToMid.next;
                head.next = first;
                head = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        if(pre == null) {
            root.next = nextToMid;
        } else if(nextToMid != null){
            pre.next = nextToMid;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);

        new SortList148().sortList(node);
    }
}