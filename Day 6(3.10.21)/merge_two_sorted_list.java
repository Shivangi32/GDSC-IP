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
        
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        ListNode c1=l1;
        ListNode c2=l2;
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val)
            {
                p.next=c1;
                c1=c1.next;
                p=p.next;
            }
            else
            {
                p.next=c2;
                c2=c2.next;
                p=p.next;
            }
        }
        if(c1!=null && c2==null)
            p.next=c1;
        else if(c1==null && c2!=null)
            p.next=c2;
        return dummy.next;
        
    }
}