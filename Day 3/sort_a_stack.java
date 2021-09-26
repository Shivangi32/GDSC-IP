// { Driver Code Starts
    import java.util.Scanner;
    import java.util.Stack;
    class SortedStack{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                Stack<Integer> s=new Stack<>();
                int n=sc.nextInt();
                while(n-->0)
                s.push(sc.nextInt());
                GfG g=new GfG();
                Stack<Integer> a=g.sort(s);
                while(!a.empty()){
                    System.out.print(a.peek()+" ");
                    a.pop();
                }
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG{
        
        public int[] mergesort(int arr[],int lo,int hi)
        {
           if(lo>=hi)
           {
            int[] ar=new int[1];
            ar[0]=arr[lo];
            return ar;
           }
            int mid=(lo+hi)/2;
            int left[]=mergesort(arr,lo,mid);
            int right[]=mergesort(arr,mid+1,hi);
            return merge(left,right);
        }
        public int[] merge(int left[],int right[])
        {
            int i=0,j=0;
            int ans[]=new int[left.length+right.length];
            int k=0;
            while(i<left.length || j<right.length)
            {
                int v1=Integer.MAX_VALUE;
                int v2=Integer.MAX_VALUE;
                if(i<left.length)
                  v1=left[i];
                if(j<right.length)
                  v2=right[j];
                if(v1<v2)
                  i++;
                else
                  j++;
                ans[k++]=Math.min(v1,v2);
            }
            return ans;
        }
        public Stack<Integer> sort(Stack<Integer> s)
        {
            //add code here.
            int arr[]=new int[s.size()];
            int k=0;
            while(s.size()>0)
               arr[k++]=s.pop();
            int ans[]=mergesort(arr,0,arr.length-1);
            for(int i=0;i<ans.length;i++)
            {
                s.push(ans[i]);
            }
            return s;
        }
    }