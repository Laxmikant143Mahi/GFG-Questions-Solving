//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Solution obj = new Solution();

            Node result = obj.findIntersection(head1, head2);
            printList(result);
        }
        sc.close();
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        // Initialize a dummy node to start the result list.
        Node dummy = new Node(0);
        // `result` will help build the intersection list.
        Node result = dummy;
        
        // Traverse both lists using two pointers.
        while (head1 != null && head2 != null) {
            // If both nodes have the same value, add it to the result.
            if (head1.data == head2.data) {
                result.next = new Node(head1.data);
                result = result.next;  // Move the result pointer forward.
                head1 = head1.next;  // Move head1 pointer forward.
                head2 = head2.next;  // Move head2 pointer forward.
            } 
            // If head1's data is smaller, move head1 forward.
            else if (head1.data < head2.data) {
                head1 = head1.next;
            } 
            // If head2's data is smaller, move head2 forward.
            else {
                head2 = head2.next;
            }
        }
        
        // Return the next node of dummy (which points to the head of the intersection list).
        return dummy.next;
    }
}

