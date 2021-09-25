import java.io.*;
import java.util.*;
public class Solution {

    public class Pair implements Comparable<Pair>{

        int start;
        int end;
        Pair(int s,int e)
        {
            start=s;
            end=e;
        }
        public int compareTo(Pair p)
        {
            if(this.start<p.start)
              return -1;
            if(this.start>p.start)
              return 1;
            return 0;
        }
    }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int c) {

        int count=0;
        Pair[] p=new Pair[arrive.size()];
        for (int k = 0; k < arrive.size(); k++) {
           p[k]=new Pair(arrive.get(k),depart.get(k));
        }
        Arrays.sort(p);
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        pq.add(p[0].end);
        for(int i=1;i<p.length;i++)
        {
            if(p[i].start==p[i].end)
              continue;
            if(p[i].start>=pq.peek())
            {
                pq.remove();
            }
            pq.add(p[i].end);
            if(pq.size()>c)
              return false;
        }
       
        return true;
    }
}
