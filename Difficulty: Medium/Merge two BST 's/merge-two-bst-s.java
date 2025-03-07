//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

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

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
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

                // Create the right child for the curr node
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

            Solution T = new Solution();
            ArrayList<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    
    void inOrder(Node root, ArrayList<Integer> list){
        
        if(root==null)
            return;
        
        
        inOrder(root.left, list);
        
        list.add(root.data);
        
        inOrder(root.right, list);
    }
    
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // Write your code here
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        
        inOrder(root1, list1);
        
        inOrder(root2, list2);
        
        int first = 0;
        int second = 0;
        
        while(first<list1.size() && second<list2.size()){
            
            if(list1.get(first) > list2.get(second)){
                
                ans.add(list2.get(second));
                
                second++;
            }
            
            else if(list1.get(first) < list2.get(second)){
                
                ans.add(list1.get(first));
                first++;
            }
            
            else {
                
                ans.add(list1.get(first));
                ans.add(list2.get(second));
                
                first++;
                second++;
            }
        }
        
        while(first<list1.size()){
            
            ans.add(list1.get(first));
            first++;
        }
        
        while(second < list2.size()){
            
            ans.add(list2.get(second));
            second++;
        }
        
        return ans;
        
    }
}
