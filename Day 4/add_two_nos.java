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
    
    public ListNode reverse(ListNode l)
    {
        ListNode prev=null;
        ListNode curr=l;
        ListNode next=l.next;
        while(curr!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null)
              next=curr.next;
        }
        return prev;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1=reverse(l1);
        l2=reverse(l2);
        ListNode res=new ListNode();
        int carry=0;
        int start=0;
        while(l1!=null || l2!=null || carry!=0)
        {
            int a=0;
            if(l1!=null)
                a=l1.val;
            int b=0;
            if(l2!=null)
                b=l2.val;
            int sum=a+b+carry;
            int digit=sum%10;
            carry=sum/10;
            ListNode node=new ListNode(digit);
            if(start==0)
                res=node;
            else
            {
                node.next=res;
                res=node;
            }
            if(l1!=null)
              l1=l1.next;
            if(l2!=null)
              l2=l2.next;
            start++;
        }
     
        return res;
    }
}