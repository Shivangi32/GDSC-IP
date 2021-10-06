/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        ListNode head=A;
        while(A!=null)
        {
            if(A.next!=null)
            {
             int temp=A.next.val;
             A.next.val=A.val;
             A.val=temp;
             A=A.next.next;
            }
            else
              A=A.next;
        }
        return head;
    }
}
