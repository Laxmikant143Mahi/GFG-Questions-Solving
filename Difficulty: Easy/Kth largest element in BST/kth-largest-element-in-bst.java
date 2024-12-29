//{ Driver Code Starts
// Initial Template for Java

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

class GfG {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine());

            Solution g = new Solution();
            System.out.println(g.kthLargest(root, k));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
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
*/
class Solution {
    
    // Helper method to perform reverse in-order traversal and find kth largest
    void findKthLargest(Node root, int[] k, int[] element) {
        if (root == null) {
            return;
        }
        
        // Traverse the right subtree first (for largest elements)
        findKthLargest(root.right, k, element);
        
        // Decrease k before checking the condition, to ensure we reach the kth largest element
        k[0]--;
        
        // If k is zero, we have found the kth largest element
        if (k[0] == 0) {
            element[0] = root.data;
            return;
        }
        
        // Traverse the left subtree
        findKthLargest(root.left, k, element);
    }
    
    // Method to return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        int[] kWrapper = {k};  // Use an array to hold k (mutable reference)
        int[] elementWrapper = {-1};  // Array to store the result
        
        findKthLargest(root, kWrapper, elementWrapper);  // Call the helper function
        
        return elementWrapper[0];  // Return the kth largest element
    }
}
