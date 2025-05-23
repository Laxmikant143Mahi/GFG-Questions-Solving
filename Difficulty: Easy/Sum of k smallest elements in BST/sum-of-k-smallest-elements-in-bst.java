//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            int n=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    System.out.println(g.sum(root,n));
                t--;
            
        
System.out.println("~");
}
    }
  
}


// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    Node(int key){
        this.data = key;
        this.left = this.right = null;
    }
}
*/

class Tree {
    // Helper method for in-order traversal and updating the sum of first k elements
    void kSum(Node root, int[] sum, int[] k) {
        if (root == null || k[0] == 0) {
            return;
        }

        // Traverse left subtree
        kSum(root.left, sum, k);

        // If we haven't reached the k smallest elements, add the current node's value
        if (k[0] > 0) {
            sum[0] += root.data; // Add current node's value to sum
            k[0]--; // Decrease the count of remaining smallest elements
        }

        // Traverse right subtree
        kSum(root.right, sum, k);
    }
    
    // Method to calculate the sum of the first k smallest elements
    int sum(Node root, int k) {
        // Array to hold sum and k (mutable by reference)
        int[] sum = {0};
        int[] kArr = {k};  // Array for mutable k value
        
        // Call the helper function to get the sum of the first k elements
        kSum(root, sum, kArr);
        
        return sum[0]; // Return the accumulated sum
    }
}
