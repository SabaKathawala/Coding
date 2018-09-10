package adobe;

public class ReverseLinkedList {
    /*
    While you are traversing the list, change the current node's next pointer to point to its previous element.
    Since a node does not have reference to its previous node, you must store its previous element beforehand.
    You also need another pointer to store the next node before changing the reference.
    Do not forget to return the new head reference at the end!
     */
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public ListNode reverseListIterative(ListNode head) {
        // reducing the number of null checks by making prev null and
        // intializing next node inside loop
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //working backwards
    //Recursion would reach the last node and then start reversing from the last node
    // go to last node
    // set last node to point to prev node
    // set prev node's next to null
    // recursively repeat above two steps
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        //set last node's next to point to prev node
        head.next.next = head;
        // set prev node's next to null
        head.next = null;
        return p;
    }
}
