//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
  // Function to detect cycle in an undirected graph.
  public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
    int V = adj.size(); // Derive the number of vertices from adj
    boolean[] visited = new boolean[V];

    // Visit all the unvisited nodes
    for (int i = 0; i < V; i++) {
      if (!visited[i] && CycleDetect(i, -1, adj, visited)) {
        return true;
      }
    }
    return false;
  }

  private boolean CycleDetect(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
    visited[node] = true;

    for (int neighbor : adj.get(node)) {
      if (!visited[neighbor]) {
        if (CycleDetect(neighbor, node, adj, visited)) {
          return true;
        }
      } else if (neighbor != parent) { // Cycle found
        return true;
      }
    }
    return false;
  }
}
