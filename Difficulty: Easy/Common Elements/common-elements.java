//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            // taking total count-1 of elements
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;

            // Declaring and Initializing an ArrayList-1
            int a[] = new int[n];

            // adding elements to the ArrayList-1
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }

            temp = sc.nextLine().trim().split(" ");
            int m = temp.length;

            // Declaring and Initializing an ArrayList-1
            int b[] = new int[m];

            // adding elements to the ArrayList-1
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(temp[i]);
            }
            Solution ob = new Solution();
            // calling the method common_element
            // and passing ArrayList 1, 2 as arguments
            // and storing the results in a new ArrayList
            ArrayList<Integer> ans = ob.commonElements(a, b);

            // printing the elements of the new ArrayList
            for (int i : ans) System.out.print(i + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public static ArrayList<Integer> commonElements(int v1[], int v2[])
    {
        //Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : v1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> commonElements = new ArrayList<>();
        
        for (int num : v2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                commonElements.add(num);  
                map.put(num, map.get(num) - 1);
            }
        }
        
        Collections.sort(commonElements);
        
        return commonElements;
    }
}