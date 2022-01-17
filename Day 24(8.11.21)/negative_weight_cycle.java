int path[]=new int[n];
	    Arrays.fill(path,Integer.MAX_VALUE);
	    path[0]=0;
	    for(int i=0;i<n-1;i++)
	    {
	        for(int e[]:edges)
	        {
	            int src=e[0];
	            int nbr=e[1];
	            int wt= e[2];
	            if(path[src]==Integer.MAX_VALUE)
	              continue;
	            if(path[src]+wt<path[nbr])
	              path[nbr]=path[src]+wt;
	        }
	    }
	    for(int e[]:edges)
	    {
	            int src=e[0];
	            int nbr=e[1];
	            int wt= e[2];
	            if(path[src]==Integer.MAX_VALUE)
	              continue;
	            if(path[src]+wt<path[nbr])
	            {
	                System.out.print(1);
	                return;
	            }
	    }
	    System.out.print(0);