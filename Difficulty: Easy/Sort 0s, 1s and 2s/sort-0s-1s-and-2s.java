//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
     public void swap(int[] arr,int i,int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    
    public void sort012(int[] arr) {
        // code here
        int l = 0,r = arr.length - 1;
        int c = 0;
        
        while(c <= r){
            if(arr[c] == 0){
                swap(arr,l,c);
                l++;
                c++;
            }else if(arr[c] == 2){
                swap(arr,r,c);
                r--;
            }else{
                c++;
            }
        }
    }
}

//{ Driver Code Starts.
// } Driver Code Ends