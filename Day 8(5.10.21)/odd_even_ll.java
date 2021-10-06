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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;
        ListNode o=head,o1=head;
        ListNode e=head.next,e1=head.next;
        while(o!=null && e!=null)
        {
            if(o.next!=null)
              o.next=o.next.next;
            if(e.next!=null)
              e.next=e.next.next;
            if(o.next!=null)
              o=o.next;
            e=e.next;
        }
        o.next=e1;
        return o1;
        
    }
}