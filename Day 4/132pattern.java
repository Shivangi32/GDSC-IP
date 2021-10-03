class Solution {
    public boolean find132pattern(int[] arr) {
        int n=arr.length;
        int min[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i==0)
              min[0]=arr[0];
            else
              min[i]=Math.min(arr[i],min[i-1]);
        }
        Stack<Integer>st=new Stack<>();
        boolean flag=false;
        for(int j=n-1;j>=0;j--)
        {
            while(st.size()>0 && st.peek()<=min[j])
            {
                st.pop();
            }
            if(st.size()>0)
            {
                if(arr[j]>st.peek())
                {
                    flag=true;
                    break;
                }
            } 
            st.push(arr[j]);
        }
        return flag;
    }
}