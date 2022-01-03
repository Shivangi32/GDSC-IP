class Solution {
    
    public boolean isbal(HashMap<Character,Integer>hm,int k)
    {
        for(int count: hm.values())
        {
            if(count>k)
                return false;
        }
        return true;
    }
    public int balancedString(String S) {
        
        HashMap<Character,Integer>hm=new HashMap<>();
        int n=S.length(),ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            char ch=S.charAt(i);
            if(hm.containsKey(ch))
            {
                int val=hm.get(ch);
                hm.put(ch,val+1);
            }
            else
            {
                hm.put(ch,1);
            }
        }
        
        int s=0,e=0,k=n/4;
        while(e<n && !isbal(hm,k))
        {
            while(e<n && !isbal(hm,k))
            {
                char ch=S.charAt(e);
                int val=hm.get(ch);
                hm.put(ch,val-1);
                e++;
            }
            ans=Math.min(ans,e-s);
            while(s<n && s<e && isbal(hm,k))
            {
                char ch=S.charAt(s);
                int val=hm.get(ch);
                hm.put(ch,val+1);
                ans=Math.min(ans,e-s);
                s++;
            }
        }
        if(ans==Integer.MAX_VALUE)
              return 0;
        return ans;
    }
}