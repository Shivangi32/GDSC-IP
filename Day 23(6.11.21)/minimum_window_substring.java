class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()<t.length())
            return "";
        HashMap<Character,Integer>hm=new HashMap<>();
        HashMap<Character,Integer>my=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            if(hm.containsKey(ch))
            {
                hm.put(ch,hm.get(ch)+1);
            }
            else
                hm.put(ch,1);
        }
        String res="",ans="";
        int st=0,e=0,n=s.length();
        int match_count=0;
        while(e<n)
        {
            while(e<n && match_count<t.length())
            {
                char ch=s.charAt(e);
                if(hm.containsKey(ch)==false)  //hm not contain character
                {
                    e++;
                    continue;
                }
                if(my.containsKey(ch))
                {
                    my.put(ch,my.get(ch)+1);
                }
                else
                    my.put(ch,1);
                if(my.get(ch)<=hm.get(ch))
                    match_count++;
                e++;
            }
            while(match_count==t.length() && st<e && e<=n)
            {
                ans=s.substring(st,e);
                if(res=="" || res.length()>ans.length())
                    res=ans;
                char ch=s.charAt(st);
                if(my.containsKey(ch))
                {
                  my.put(ch,my.get(ch)-1);
                  if(my.get(ch)<hm.get(ch))
                      match_count--;
                  if(my.get(ch)==0)
                      my.remove(ch);
                }
                st++;
            }
        }
        return res;
    }
}