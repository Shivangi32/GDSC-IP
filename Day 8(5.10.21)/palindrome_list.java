/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    ListNode left;
    public int size(ListNode head)
    {
        int s=0;
        while(head!=null)
        {
            s++;
            head=head.next;
        }
        return s;
    }
    public int helper(ListNode right,int idx,int size)
    {
        if(right==null)
          return 1;
        int faith=helper(right.next,idx+1,size);
        if(faith==0)
          return 0;
        if(idx>=size/2 && left.val!=right.val)
        {
            left=left.next;
            return 0;
        }
        left=left.next;
        return 1;
    }
    public int lPalin(ListNode A) {

        left=A;
        return helper(A,0,size(A));
    }
}
