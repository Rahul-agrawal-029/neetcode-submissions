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
        int i = 0;
        ListNode end=head;
        while(i<n){
            i++;
            end = end.next;
        }
        ListNode start = head;
        ListNode prev = null;
        while(end!=null){
            end= end.next;
            prev=start;
            start=start.next;
        }
        if(prev==null){
            return start.next;
        }
        prev.next=start.next;
        return head;
    }
}
