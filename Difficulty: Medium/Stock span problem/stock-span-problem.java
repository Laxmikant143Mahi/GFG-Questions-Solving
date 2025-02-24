//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to calculate the span of stock's price for all n days.
    private static class Pair{
        
        int day;
        int spanCnt;
        public Pair(int day,int spanCnt){
            this.day=day;
            this.spanCnt=spanCnt;
        }
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        
        //TLE..
        // ArrayList<Integer> ans=new ArrayList<>();
        
        // int n=arr.length;
        
        // for(int i=0;i<n;i++){
        //     int cnt=1;
        //     for(int j=i-1;j>=0;j--){
        //         if(arr[i]>=arr[j]){
        //             cnt++;
        //         }
        //         else{
        //             break;
        //         }
        //     }
        //     ans.add(cnt);
        // }
        
        // return ans;
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        
        Stack<Pair> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            
            int stockSpan=1;
            while(!st.isEmpty() && st.peek().day<=arr[i]){
        
                stockSpan+=st.peek().spanCnt;
                st.pop();
            }
            
            ans.add(stockSpan);
            st.push(new Pair(arr[i],stockSpan));
        }
        
        return ans;
        
    }
}
