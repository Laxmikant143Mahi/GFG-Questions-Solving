//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Node> s1 = new Stack<>();
        
        Stack<Node> s2 = new Stack<>();
        
        
        //All left side push into stack
        while(root1!=null){
            
            s1.push(root1);
            
            root1 = root1.left;
        }
        
        while(root2!=null){
            
            s2.push(root2);
            
            root2 = root2.left;
        }
        
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            
            //top element equal
            
            if(s1.peek().data == s2.peek().data){
                
                ans.add(s1.peek().data);
                
                root1 = s1.peek().right;
                
                s1.pop();
                
                root2 = s2.peek().right;
                
                s2.pop();
            }//s1 > s2
            else if(s1.peek().data > s2.peek().data){
                
                root2 = s2.peek().right;
                
                s2.pop();
            }else{ //s1 < s2
                root1 = s1.peek().right;
                
                s1.pop();
            }
            
            
                 while(root1!=null){
                
                s1.push(root1);
                
                root1 = root1.left;
            }
            
            while(root2!=null){
                
                s2.push(root2);
                
                root2 = root2.left;
            }
           
        }
        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1, root2);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends