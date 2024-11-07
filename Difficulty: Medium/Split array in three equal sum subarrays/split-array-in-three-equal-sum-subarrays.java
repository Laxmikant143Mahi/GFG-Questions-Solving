//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public List<Integer> findSplit(int[] arr) {
        List<Integer> result = new ArrayList<>(Arrays.asList(-1, -1));
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }


        if (totalSum % 3 != 0) {
            return result;
        }

        int targetSum = totalSum / 3;
        int currentSum = 0;
        int firstIndex = -1, secondIndex = -1;


        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];


            if (currentSum == targetSum && firstIndex == -1) {
                firstIndex = i;
            } 

            else if (currentSum == 2 * targetSum && firstIndex != -1) {
                secondIndex = i;
                result.set(0, firstIndex);
                result.set(1, secondIndex);
                return result;
            }
        }

        return result; 
    }
}