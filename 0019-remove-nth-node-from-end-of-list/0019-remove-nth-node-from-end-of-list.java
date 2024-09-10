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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp=head;


        while(temp!=null){
            temp=temp.next;
            count++;
        }

          if (count == n) {
            
            return head.next;  // Return the second node as the new head
        }
        count =count-n;
        temp=head;
        for(int i=1;i<count;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;

        return head;

    }
}