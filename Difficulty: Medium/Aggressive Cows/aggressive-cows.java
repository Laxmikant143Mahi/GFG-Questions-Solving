//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
   static boolean  canPlaceCows(int stalls[], int minDis, int cows){
        
        int cowsCount=1;
        int last = stalls[0];
        
        for(int i=1; i<stalls.length; i++){
            
            if(stalls[i]-last >= minDis){
                cowsCount++;
                last = stalls[i];
            }
            if(cowsCount >=cows) return true;
        }
        return false;
        
        
        
    }
    public static int aggressiveCows(int[] stalls, int cows) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        
        int ans = -1;
        int start = 0;
        int end = stalls[n-1] - stalls[0];
        
        while(start<=end){
            
            int mid = (start+end)>>1;
            
            if(canPlaceCows(stalls,mid,cows)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
                
        }
        return ans;
        
    }
}