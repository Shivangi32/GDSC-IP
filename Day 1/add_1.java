public class Solution {
    public int[] plusOne(int[] A) {

        int carry=1;
        int l=A.length;
        int i=l-1;
        int si=0;   // si=starting index
        while(si<l && A[si]==0)    // to remove the following zeroes in nos like 00123
          si++;

        if(si==l)    // to check if the no is 0
        {
            int res[]=new int[1];
            res[0]=1;
            return res;
        }
        while(i>=si)
        {
            int sum=A[i]+carry;
            int digit=sum%10;
            carry=sum/10;
            A[i]=digit;
            i--;
        }
        int k=0;
        if(carry==1)
        {
            l++;
            k++;
        }
        int res[]=new int[l-si];
        if(carry==1)
          res[0]=1;
        for(int j=si;j<A.length;k++,j++)
        {
            res[k]=A[j];
        }
        return res;
    }
}
