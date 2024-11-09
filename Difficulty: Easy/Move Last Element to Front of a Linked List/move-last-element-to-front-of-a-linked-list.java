//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node(Integer.parseInt(s[i]));

        return head;
    }

    public static void printList(Node node) {
        while (true) {
            System.out.print(node.data);
            node = node.next;
            if (node == null) break;
            System.out.print(" ");
        }
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            Solution obj = new Solution();
            Node res = obj.moveToFront(head);

            Node.printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node moveToFront(Node head) {
        // code here
        Node temp1 = head.next;
        Node temp2 = head;
        
        while(temp1.next!=null){
            temp1= temp1.next;
            temp2 = temp2.next;
        }
            
        temp2.next = temp1.next;
        Node next = new Node(temp1.data);
        
        next.next = head;
        return next;
        
    }
}
