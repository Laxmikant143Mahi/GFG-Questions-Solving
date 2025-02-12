//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.isFrequencyUnique(n, arr);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
     
        }
        
        
        HashMap<Integer,Integer> map2 = new HashMap<>();
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            
            
            map2.put(entry.getValue(), map2.getOrDefault(entry.getValue(),0)+1);
            
            if(map2.get(entry.getValue()) > 1)
                return false;
        }
        return true;
        
        
    }
}
        
