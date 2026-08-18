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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode trav1=list1;
        ListNode trav2=list2;
        ListNode trav3=dummy;

        while(trav1!=null & trav2!=null){
            // System.out.println("trav1"+trav1.val);
            // System.out.println("trav2"+trav2.val);
            // System.out.println("trav3"+trav3.val);
            if(trav2.val>trav1.val){
                    trav3.next=trav1;
                    trav1=trav1.next;
                    trav3=trav3.next;
                }
                
            else if(trav1.val>=trav2.val){
                    trav3.next=trav2;
                    trav2=trav2.next;
                    trav3=trav3.next;
                }
            }
        if(trav1==null){
            while(trav2!=null){
                trav3.next=trav2;
                trav2=trav2.next;
                trav3=trav3.next;
            }
        }
        else if(trav2==null){
            trav3.next=trav1;
            trav1=trav1.next;
            trav3=trav3.next;
        }

        return dummy.next;
    }
}