package leetcode;

public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currHead = head;
        ListNode prevHead = head;
        int counter = 1;

        //setting head
        while(currHead != null && counter < k) {
            currHead = currHead.next;
            counter++;
        }
        ListNode next  = null;
        if(counter == k) {
            next = currHead.next;
            currHead.next = null;
            reverse(head);
            prevHead.next = next;
            head = currHead;
            currHead = next;
        }


        while(currHead != null || currHead.next != null) {
            counter = 1;
            ListNode kAhead = currHead;
            while(kAhead != null && counter < k) {
                kAhead = kAhead.next;
                counter++;
            }
            if(counter == k) {
                next = kAhead.next;
                kAhead.next = null;
                reverse(currHead);
                prevHead.next = kAhead;
                currHead.next = next;
                prevHead = currHead;
                currHead = next;
            }
        }
        return head;
    }

    private static void reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    }

    public static void main(String[] args) {
//        ListNode list = new ListNode(1);
//        list.next = new ListNode(2);
//        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
//        list.next.next.next.next = new ListNode(5);
//
//        new ReverseNodeInKGroups().reverseKGroup(list, 2);

        String[] one = "0.1".split("\\.");
        String[] two = "1.1".split("\\.");

        int min = Math.min(one.length, two.length);

        for(int i=0; i<min; i++) {
            if(Integer.parseInt(one[i]) > Integer.parseInt(two[i])){
                System.out.println(1);;
            }
            if(Integer.parseInt(one[i]) < Integer.parseInt(two[i])){
                System.out.println(-1);
            }
        }

        if(one.length > two.length) {
            System.out.println(1);
        }
        if(one.length < two.length) {
            System.out.println(-1);
        }
        System.out.println(0);
    }
}