//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

      class Solution {

    int countPairs(int arr[], int target) {

        int n=arr.length;

        int left=0;

        int right=n-1;

        int count=0;

        while(left<right){

            int sum=arr[left]+arr[right];

            if(sum==target){

               count++; 

               int tempright=right-1;

               while(tempright>left &&          arr[left]+arr[tempright]==target){

                   count++;

                   tempright--;

               }

               left++;

            }

                 else if(sum>target){

                   right--;

               }

               else {

                   left++;

               }

            }

            return count;

        }

}



//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends