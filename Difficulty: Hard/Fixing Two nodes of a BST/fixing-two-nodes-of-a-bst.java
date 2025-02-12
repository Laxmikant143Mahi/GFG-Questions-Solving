//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
class pair
{
    int first;
    int second;
    pair(int first , int second)
        {
            this.first = first;
            this.second = second;
        }
}
class GfG {
    
    static Node buildTree(String str)
    {
        
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
    
    public static boolean isBST(Node n, int lower, int upper)
    {
        if(n==null)
            return true;
        if( n.data <= lower || n.data >= upper )
            return false;
        return (  isBST( n.left, lower, n.data )  &&  isBST( n.right, n.data, upper )  );
    }

    public static boolean compare( Node a, Node b, ArrayList<pair> mismatch )
    {
        if( a==null && b==null ) return true;
        if( a==null || b==null ) return false;
        
        if( a.data != b.data )
            {
                pair temp = new pair(a.data,b.data);
                mismatch.add(temp);
            }
            
        
        return ( compare( a.left, b.left, mismatch ) && compare( a.right, b.right, mismatch ) );
    }
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0)
	        {
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	Node duplicate = buildTree(s);
    	    	
                Solution ob = new Solution();
        		
        		Node temp = ob.correctBST(root);
        		if(temp != root)
        		    System.out.println(0);
        		
        		 // check 1: is tree now a BST
                if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false)
                {
                    System.out.println(0);
                    continue;
                }
                
                // check 2: comparing with duplicate tree
                
               
                ArrayList<pair> mismatch = new ArrayList<pair>();
                // an arraylist to store data of mismatching nodes
                
                if( compare( root, duplicate, mismatch) == false)
                {
                    // false output from this function indicates change in structure of tree
                    System.out.println(0);
                    continue;
                }
                
                // finally, analysing the mismatching nodes
                if( mismatch.size() !=2 || mismatch.get(0).first!=mismatch.get(1).second || mismatch.get(0).second!=mismatch.get(1).first )
                    System.out.println(0);
                else
                    System.out.println(1);
            
                    
            
            
System.out.println("~");
}
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    void correctTree(Node root, int[] nodesToCorrect, int[] index) {
        if (root == null)
            return;

        correctTree(root.left, nodesToCorrect, index);

        if (root.data == nodesToCorrect[0] || root.data == nodesToCorrect[1]) {
            root.data = (root.data == nodesToCorrect[0]) ? nodesToCorrect[1] : nodesToCorrect[0];
            index[0]--;
        }

        if (index[0] <= 0) return; // If we've swapped both nodes, no need to continue

        correctTree(root.right, nodesToCorrect, index);
    }

    // Function to fix a given BST where two nodes are swapped.  
    public Node correctBST(Node root) {
        // Step 1: Perform in-order traversal to collect node values
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        // Step 2: Identify the two swapped nodes
        int first = -1, second = -1;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                if (first == -1) {
                    first = i;
                    second = i + 1;
                } else {
                    second = i + 1;
                }
            }
        }

        // The values of the two swapped nodes
        int[] nodesToCorrect = {list.get(first), list.get(second)};

        // Step 3: Traverse the tree again and correct the swapped nodes
        int[] index = {2}; // To track how many corrections are left
        correctTree(root, nodesToCorrect, index);

        return root;
    }

}
