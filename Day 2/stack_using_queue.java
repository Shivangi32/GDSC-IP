class MyStack {
    
    Queue<Integer>main;
    Queue<Integer>helper;

    public MyStack() {
        
        main=new ArrayDeque<>();
        helper=new ArrayDeque<>();
        
    }
    
    public void push(int x) {
        
        main.add(x);
    }
    
    public int pop() {
        
        while(main.size()>1)
        {
            helper.add(main.remove());
        }
        int ans=main.remove();
        
        while(helper.size()>0)
            main.add(helper.remove());
        return ans;
    }
    
    public int top() {
        
        while(main.size()>1)
        {
            helper.add(main.remove());
        }
        int ans=main.remove();
        helper.add(ans);
        while(helper.size()>0)
            main.add(helper.remove());
         return ans;
    }
    
    public boolean empty() {
        
        if(main.size()==0)
            return true;
        else
            return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */