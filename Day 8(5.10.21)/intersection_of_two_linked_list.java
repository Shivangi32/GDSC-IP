/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public int size(ListNode l)
    {
        int s=0;
        while(l!=null)
        {
            s++;
            l=l.next;
        }    
        return s;
        
    }
    public ListNode getIntersectionNode(ListNode n1, ListNode n2) {
        
      int s1=size(n1);
      int s2=size(n2);
      if(s1>s2)
      {
          int extra=s1-s2;
          while(extra>0)
          {
              n1=n1.next;
              extra--;
          }
      }
      else if(s2>s1)
      {
          int extra=s2-s1;
          while(extra>0)
          {
              n2=n2.next;
              extra--;
          }
      }
      while(n1!=n2)
      {
          n1=n1.next;
          n2=n2.next;
      }
      return n1;
        
    }
}