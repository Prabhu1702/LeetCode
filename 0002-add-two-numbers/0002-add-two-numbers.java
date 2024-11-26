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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify list creation
        ListNode temp = dummy;
        int carry = 0;

        // Loop through both linked lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with the carry

            // Add the value from l1 if it's not null
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;  // Move to the next node
            }

            // Add the value from l2 if it's not null
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;  // Move to the next node
            }

            // Update carry for the next iteration
            carry = sum / 10;

            // Create a new node with the current digit (sum % 10) and add to the result
            temp.next = new ListNode(sum % 10);
            temp = temp.next;  // Move temp to the next node
        }

        // Return the result list, starting from dummy.next (skip the dummy node)
        return dummy.next;
    }
}
