//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        int start = 0, end = arr2.length - 1;
        int pos = -1;
        
        // Binary search on the smaller array (arr2)
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr1[mid] == arr2[mid]) {
                // If elements are the same, move to the right
                start = mid + 1;
            } else {
                // If elements are different, update position and move to the left
                pos = mid;
                end = mid - 1;
            }
        }
        
        // If no mismatch in the first `arr2.length` elements, the extra element is at the end of arr1
        return (pos == -1) ? arr1.length - 1 : pos;
    }
}
