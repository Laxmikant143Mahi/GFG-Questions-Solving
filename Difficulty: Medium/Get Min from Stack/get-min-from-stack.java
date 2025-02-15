//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		
System.out.println("~");
}
		
	}
}



// } Driver Code Ends




class GfG {
    int minEle;
    Stack<Integer> s;
    Stack<Integer> minStack;

    // Constructor    
    GfG() {
        s = new Stack<>();
        minStack = new Stack<>();
    }

    /* Returns min element from stack */
    int getMin() {
        if (minStack.isEmpty()) {
            return -1; // Stack is empty
        }
        return minStack.peek();
    }

    /* Returns popped element from stack */
    int pop() {
        if (s.isEmpty()) {
            return -1; // Stack is empty
        }
        int popped = s.pop();
        if (popped == minStack.peek()) {
            minStack.pop(); // Remove from minStack if it's the minimum
        }
        return popped;
    }

    /* Push element x into the stack */
    void push(int x) {
        s.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x); // Update minStack if x is a new minimum
        }
    }
}
