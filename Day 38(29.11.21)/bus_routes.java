class Solution {
    public  int numBusesToDestination(int[][] routes, int S, int T) {
      
      HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();
      HashMap<Integer,Boolean> stop=new HashMap<>();
      boolean bus[]=new boolean[routes.length];
      for(int i=0;i<routes.length;i++)
      {
          for(int j=0;j<routes[i].length;j++)
          {
              int st=routes[i][j];
              if(hm.containsKey(st))
              {
                  hm.get(st).add(i);
              }
              else
              {
                  ArrayList<Integer>temp=new ArrayList<>();
                  temp.add(i);
                  hm.put(st,temp);
                  stop.put(st,false);
              }
          }
      }
      
      
      Queue<Integer>qu=new ArrayDeque<>();
      Queue<Integer>helper=new ArrayDeque<>();
      qu.add(S);
      int lvl=0;
      boolean flag=false;
      while(qu.size()>0){
           flag=false;
      while(qu.size()>0)
      {
          int rem=qu.remove();
          ArrayList<Integer>temp=hm.get(rem);
          if(rem==T)
          {
              flag=true;
              break;
          }
          stop.put(rem,true);
          for(int pbus:temp)
          {
              if(bus[pbus]==true)
                continue;
              for(int j=0;j<routes[pbus].length;j++)
              {
                 int pstop=routes[pbus][j];
                 if(stop.get(pstop)==true)
                   continue;
                 helper.add(pstop);
                 stop.put(pstop,true);
              }
              bus[pbus]=true;
          }
      }
      if(flag==true)
        break;
      qu=helper;
      helper=new ArrayDeque<>();
      lvl++;
      }
      if(flag==false)
        return -1;
      return lvl;

  }
}