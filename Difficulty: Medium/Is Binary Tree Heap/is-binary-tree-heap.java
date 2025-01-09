//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    
    int countNodes(Node root){
        
        if(root==null)
            return 0;
        
        return 1+countNodes(root.left) + countNodes(root.right);
        
    }
    
    boolean checkCBT(Node root, int index, int count){
        
        if(root==null)
            return true;
            
        if(index>=count)
            return false;
        
        //Left side CBT Check
         //Right Side CBT Check
        return checkCBT(root.left, 2*index+1, count) && checkCBT(root.right, 2*index+2, count);
    }
    
    boolean isMaxHeap(Node root){
      
      if(root.left!=null){
          
          if(root.data < root.left.data)
            return false;
           if(isMaxHeap(root.left) == false)
            return false;
      }
      
      if(root.right!=null){
          
          if(root.data < root.right.data)
            return false;
            
          return isMaxHeap(root.right);
           
      }
      return true;
    }
    boolean isHeap(Node tree) {
        
        // Count Ndoes in Tree 
        
        int count = countNodes(tree);
        
        // CBT Property
        if(checkCBT(tree, 0, count) == false)  
            return false;
        
        return isMaxHeap(tree);
        
     
        // Parent >= Childs
        
        
    }
}