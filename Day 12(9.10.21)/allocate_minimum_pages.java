if(m>n)
      return -1;
    int lo=0,hi=0;
    for(int val:arr)
    {
        hi+=val;
        lo=Math.max(lo,val);
    }
    if(m==n)
      return lo;
    while(lo<=hi)
    {
        int mid=(lo+hi)/2;
        int stud=1,sum=0,i=0;
        while(i<n)
        {
            sum+=arr[i];
            if(sum>mid)
            {
                stud++;
                sum=arr[i];
            }
            i++;
        }
        if(stud<=m)
        {
            ans=mid;
            hi=mid-1;
        }
        else
          lo=mid+1;

    }
    
    return ans;