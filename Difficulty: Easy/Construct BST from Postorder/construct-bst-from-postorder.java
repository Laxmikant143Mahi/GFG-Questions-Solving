//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.Math;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG {
    
    public Node BST(int[] post, int[] index, int lower, int upper) {
        
        if(index[0] <0 || post[index[0]]<lower || post[index[0]] > upper)
            return null;
            
        int val = post[index[0]--];
        Node root = new Node(val);

        root.right = BST(post, index, val, upper); // Right subtree
        root.left = BST(post, index, lower, val);  // Left subtree
        

        return root;
    }
    // Function that constructs BST from its preorder traversal.
    public Node constructTree(int post[], int size) {
        int[] index = {size-1}; // Using an array to mimic pass-by-reference for index
        return BST(post, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
}

//{ Driver Code Starts.
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG2 {
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] post = new int[n];
            for (int i = 0; i < n; i++) {
                int b = sc.nextInt();
                post[i] = b;
            }
            GFG obj = new GFG();
            Node root = obj.constructTree(post, n);
            inorder(root);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends