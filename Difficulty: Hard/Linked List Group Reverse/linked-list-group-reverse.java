//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if (head == null || k <= 1) return head;
        ArrayList<Integer> helper=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        while(head!=null){
            helper.add(head.data);
            head=head.next;
        }
        int n=helper.size();
        for (int i = 0; i < n; i += k) {
            if (i + k <= n) {
                // Reverse k-sized group
                ArrayList<Integer> temp = new ArrayList<>(helper.subList(i, i + k));
                Collections.reverse(temp);
                res.addAll(temp);
            } else {
                // Reverse the remaining group at the end
                ArrayList<Integer> temp = new ArrayList<>(helper.subList(i, n));
                Collections.reverse(temp);
                res.addAll(temp);
            }
        }
        Node h=null,temp=null;
        for(int i=0;i<res.size();i++){
            Node toAdd = new Node(res.get(i));
            if (h == null) {
                h = temp = toAdd;
            } else {
                temp.next = toAdd;
                temp = temp.next;
            }
        }
        return h;
    }
}