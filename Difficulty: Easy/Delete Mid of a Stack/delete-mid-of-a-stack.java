//{ Driver Code Starts
// Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int sizeOfStack = sc.nextInt();
            Stack<Integer> myStack = new Stack<>();

            // adding elements to the stack
            for (int i = 0; i < sizeOfStack; i++) {
                int x = sc.nextInt();
                myStack.push(x);
            }
            Solution obj = new Solution();
            obj.deleteMid(myStack, sizeOfStack);

            while (!myStack.isEmpty()) {
                System.out.print(myStack.peek() + " ");
                myStack.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        
        Stack<Integer> tempStack = new Stack<>();
        
        int count=0;
        while(count<sizeOfStack/2){
            
            int element = s.peek();
            s.pop();
            
            tempStack.push(element);
            
            count++;
            
        }
        s.pop();
        
        while(!tempStack.empty()){
            
            s.push(tempStack.peek());
            tempStack.pop();
        }

    }
}
