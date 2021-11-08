class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            int val=1;
            if(hm.containsKey(ch))
              val=hm.get(ch)+1;
            hm.put(ch,val);
        }
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            if(hm.containsKey(ch))
            {
                int val=hm.get(ch);
                hm.put(ch,val-1);
            }
            else
                return false;
            if(hm.get(ch)==0)
                hm.remove(ch);
        }
        if(hm.size()>0)
            return false;
        return true;
        
    }
}