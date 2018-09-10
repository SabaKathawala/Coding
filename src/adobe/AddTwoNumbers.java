package adobe;

/*
Question:
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/*
Solution:
1. Initialize current node to dummy head of the returning list.
2. Initialize carry to 00.
3. Initialize p and q to head of l1 and l2 respectively.
4. Loop through lists l1 and l2 until you reach both ends.
5. Set x to node p's value. If p has reached the end of l1, set to 0.
6. Set y to node q's value. If q has reached the end of l2, set to 0.
7. Set sum = x + y + carry
8. Update carry = sum / 10.
9. Create a new node with the digit value of (sum mod 10) and set it to current node's next, then advance current node to next.
10. Advance both p and q.
11. Check if carry = 1, if so append a new node with digit 1 to the returning list.
12. Return dummy head's next node.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //just a dummy starting node for the new list: simplifies code
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            // check for nulls and return the right value
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            //calculate sum and carry
            int sum = carry + x + y;
            carry = sum / 10;

            //create a new node
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // check for null and iterate
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // if the last node gives a carry
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        //return the second node from new list
        return dummyHead.next;
    }
}
