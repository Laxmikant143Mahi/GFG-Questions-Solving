//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

class GfG {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static Node inputList() throws IOException {
        String s[] = in.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0]));
        Node copy = head;
        for (int i = 1; i < s.length; i++) {
            Node temp = new Node(Integer.parseInt(s[i]));
            copy.next = temp;
            copy = copy.next;
        }
        return head;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String args[]) throws IOException {
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head1 = inputList();

            Node head2 = inputList();

            Solution obj = new Solution();

            printList(obj.findUnion(head1, head2));
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    public static Node findUnion(Node head1, Node head2) {
        // Add your code here.
        
        HashSet<Integer> set = new HashSet<>();
        
        while(head1!=null){
            set.add(head1.data);
            head1 = head1.next;
        }
        
        while(head2!=null){
            set.add(head2.data);
            head2 = head2.next;
        }
        
        List<Integer> list = new ArrayList<>(set); 
        Collections.sort(list); 
        
        
        Node dummy = new Node(0);
        Node result = dummy;
        
        for(int i=0; i<list.size() ;i++){
            result.next = new Node(list.get(i));
            result = result.next;
        }
        return dummy.next;
    }
}