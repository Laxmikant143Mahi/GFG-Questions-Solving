//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
   // Function to check if brackets are balanced or not.
    static boolean isBalanced(String x)
    {
        // Create a stack to store opening brackets.
        Stack<Character> stack = new Stack<>();
        
        // Traverse through each character in the expression.
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            
            // If it's an opening bracket, push it onto the stack.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket, check if the stack is non-empty and
            // if it matches the corresponding opening bracket.
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty or doesn't match, return false.
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were matched, return true.
        return stack.isEmpty();
    }
    
    // Helper function to check if the opening and closing brackets match.
    static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
