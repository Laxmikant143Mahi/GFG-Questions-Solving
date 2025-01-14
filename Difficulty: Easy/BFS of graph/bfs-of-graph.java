//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Queue to manage the BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        
        // List to track visited nodes
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(V, 0));
        
        // List to store the BFS traversal result
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Start BFS from node 0
        queue.add(0);
        visited.set(0, 1);
        
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Dequeue a node
            ans.add(node);          // Add it to the result
            
            // Traverse all adjacent nodes
            for (int j = 0; j < adj.get(node).size(); j++) {
                int neighbor = adj.get(node).get(j);
                if (visited.get(neighbor) == 0) { // If not visited
                    visited.set(neighbor, 1);    // Mark as visited
                    queue.add(neighbor);         // Enqueue the node
                }
            }
        }
        return ans;
    }
}
