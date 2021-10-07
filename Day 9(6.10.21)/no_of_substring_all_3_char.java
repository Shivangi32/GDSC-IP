class Solution {
    public int numberOfSubstrings(String S) {
        
        int s=0,e=0,ans=0;
        int ca=0,cb=0,cc=0;
        int n=S.length();
        while(e<=n && s<n)
        {
            while(e<n && (ca==0 || cb==0 || cc==0))
            {
                char ch=S.charAt(e);
                switch(ch)
                {
                    case 'a': ca++;break;
                    case 'b': cb++;break;
                    case 'c': cc++;break;
                }
                e++;
            }
            if(ca!=0 && cb!=0 && cc!=0)
                ans+=1+n-e;
            char ch=S.charAt(s);
            switch(ch)
                {
                    case 'a': ca--;break;
                    case 'b': cb--;break;
                    case 'c': cc--;break;
                }
            s++;
        }
        return ans;
        
    }
}