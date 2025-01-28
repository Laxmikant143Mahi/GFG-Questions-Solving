//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        HashSet<String> set = new HashSet<>(); 
        char[] chars = s.toCharArray();
        permutation(chars, 0, set);
        return new ArrayList<>(set); 
    }

    private void permutation(char[] chars, int idx, HashSet<String> set) {
        if (idx == chars.length) {
            set.add(new String(chars)); 
            return;
        }

        for (int i = idx; i < chars.length; i++) {
            swap(chars, i, idx); 
            permutation(chars, idx + 1, set); 
            swap(chars, i, idx); 
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}