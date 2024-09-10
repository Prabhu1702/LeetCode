class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;  // Return null if the list is empty
        }

        
        if (head.next == null) {
            return null; 
        }

        
        if (head.next.next == null) {
             head.next=null;
            return head;  
        }

    
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;  // To keep track of the node before slow

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;  // Remove the middle node
        return head;
    }
}
