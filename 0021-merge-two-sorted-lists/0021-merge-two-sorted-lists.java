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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to act as the start of the new list
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Traverse both lists until one of them is null
        while (l1 != null && l2 != null) {
            // Compare the values of l1 and l2
            if (l1.val <= l2.val) {
                // If l1's value is smaller or equal, link it to the new list
                temp.next = l1;
                l1 = l1.next; // Move l1 to the next node
            } else {
                // If l2's value is smaller, link it to the new list
                temp.next = l2;
                l2 = l2.next; // Move l2 to the next node
            }
            temp = temp.next; // Move the temp pointer to the next node
        }

        // If either l1 or l2 has remaining nodes, append them to the merged list
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        // Return the merged list starting from dummy.next
        return dummy.next;
    }
}
