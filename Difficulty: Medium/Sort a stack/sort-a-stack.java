//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/


class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // Temporary stack to store elements in descending order
        Stack<Integer> tempStack = new Stack<>();
        
        while (!s.isEmpty()) {
            // Take the top element from the original stack
            int current = s.pop();
            
            // Move elements from tempStack to s if they are smaller than the current element
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                s.push(tempStack.pop());
            }
            
            // Push the current element into tempStack
            tempStack.push(current);
        }
        
        // Return the sorted stack with the largest element on top
        return tempStack;
    }
}
