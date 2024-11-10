//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) { this.data = data; }
}

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            Node ans = ob.modifyTheList(head);
            while (ans != null) {
                out.print(ans.data + " ");
                ans = ans.next;
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static Node modifyTheList(Node head) {
        // Step 1: Calculate the length of the linked list
        Node currentNode = head;
        int length = 0;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        // Step 2: Store the values of the linked list nodes in an array
        int[] values = new int[length];
        currentNode = head;
        for (int i = 0; i < length; i++) {
            values[i] = currentNode.data;
            currentNode = currentNode.next;
        }

        // Step 3: Modify the values in the first half of the array
        for (int i = 0; i < length / 2; i++) {
            int originalValue = values[i];
            values[i] = values[length - 1 - i] - originalValue;
            values[length - 1 - i] = originalValue;
        }

        // Step 4: Update the linked list with the modified values from the array
        currentNode = head;
        for (int i = 0; i < length; i++) {
            currentNode.data = values[i];
            currentNode = currentNode.next;
        }

        // Return the modified head of the linked list
        return head;
    }
}
