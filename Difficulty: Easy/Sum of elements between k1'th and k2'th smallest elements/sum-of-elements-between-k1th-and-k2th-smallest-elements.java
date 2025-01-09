//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            StringTokenizer stt = new StringTokenizer(br.readLine());
            long k1 = Long.parseLong(stt.nextToken());
            long k2 = Long.parseLong(stt.nextToken());
            
            Solution obj = new Solution();
            System.out.println( obj.sumBetweenTwoKth(a, n, k1, k2) );
            
        
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    public static long sumBetweenTwoKth(long A[], long N, long k1, long k2) {
        // Create a min-heap (default behavior of PriorityQueue)
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        // Add all elements into the min-heap
        for (long num : A) {
            minHeap.add(num);
        }
        
        // Remove the first k1 smallest elements
        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }
        
        // Sum elements between k1 and k2 (exclusive)
        long sum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++) {
            sum += minHeap.poll();
        }
        
        return sum;
    }
}
