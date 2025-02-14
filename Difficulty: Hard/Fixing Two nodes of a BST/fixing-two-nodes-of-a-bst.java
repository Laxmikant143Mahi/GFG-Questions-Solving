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

class pair {
    int first;
    int second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class GfG {

    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper);
    }

    static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.data != b.data) {
            mismatch.add(new pair(a.data, b.data));
        }

        return compare(a.left, b.left, mismatch) && compare(a.right, b.right, mismatch);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Solution ob = new Solution();
            ob.correctBST(root);

            if (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                System.out.println(0);
                continue;
            }

            ArrayList<pair> mismatch = new ArrayList<>();
            if (!compare(root, duplicate, mismatch)) {
                System.out.println(0);
                continue;
            }

            if (mismatch.size() != 2 ||
                mismatch.get(0).first != mismatch.get(1).second ||
                mismatch.get(0).second != mismatch.get(1).first) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
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
*/



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