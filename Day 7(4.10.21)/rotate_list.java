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
    
    public ListNode getNode(int des,ListNode head)
    {
        int i=0;
        while(i<des)
        {
            head=head.next;
            i++;
        }
        return head;
    }
    public void reverse(int start, int end, ListNode head){
        
        while(start<=end)
        {
            ListNode n1=getNode(start,head);
            ListNode n2=getNode(end,head);
            int temp=n1.val;
            n1.val=n2.val;
            n2.val=temp;
            start++;
            end--;
        }
        
    }
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || k==0)
            return head; 
        int size=0;
        ListNode c1=head;
        while(c1!=null)
        {
            size++;
            c1=c1.next;
        }
        k=k%size;
        int n=size-k-1;
        reverse(0,n,head);
        reverse(n+1,size-1,head);
        reverse(0,size-1,head);
        return head;
    }
}