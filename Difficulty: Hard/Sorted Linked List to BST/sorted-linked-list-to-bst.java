//{ Driver Code Starts
import java.io.*;
import java.util.*;

class LNode {
    int data;
    LNode next;

    LNode(int d) {
        data = d;
        next = null;
    }
}

class TNode {
    int data;
    TNode left, right;

    TNode(int x) {
        data = x;
        left = right = null;
    }
}

class ListToBST {

    /* Function to print linked list */
    public static void preOrder(TNode root) {

        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) throws IOException {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            LNode head = new LNode(Integer.parseInt(str[0]));
            LNode tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new LNode(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            TNode root = obj.sortedListToBST(head);
            preOrder(root);

            System.out.println();

            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d;
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }

}*/

class Solution {
    
    TNode buildBST(ArrayList<Integer> tree, int start, int end){
        
        
        
        if(start > end){
            return null;
        }
        
        
        
        int mid = (start+end+1)/2;
        
        TNode root = new TNode(tree.get(mid));
        
        root.left = buildBST(tree, start, mid-1);
        
        root.right = buildBST(tree, mid+1, end);
        
        return root;
        
        
    }
    public TNode sortedListToBST(LNode head) {
        // code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(head!=null){
            list.add(head.data);
            head = head.next;
        }
        
        
        return buildBST(list, 0, list.size()-1);
    }
}