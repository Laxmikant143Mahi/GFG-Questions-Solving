//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        
System.out.println("~");
}
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int maxOnes (int Mat[][], int N, int M)
    {
        // your code here
        int minRow=Integer.MIN_VALUE;
        int rowOne=0;
        int index=-1;
        for(int i=0; i<N; i++){
            
            rowOne = 0;
            for(int j=0; j<M ;j++){
                
                if(Mat[i][j] == 1)
                    rowOne++;
            }
            if(rowOne>minRow){
                minRow = rowOne;
                index = i;
            }
        }
        return index;
    }
}