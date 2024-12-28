//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> result = new ArrayList<>();
        
        int len = arr.length;
        
        Map<Integer , ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<len; i++)
        {
            int val = arr[i];
            if(!map.containsKey(val))
            {
                map.put(val , new ArrayList<>());
            }
            map.get(val).add(i);
        }   
        
        for(int i=0; i<len-2; i++)
        {
            for(int j=i+1; j<len-1; j++)
            {
                int target = -(arr[i] + arr[j]);
                if(map.containsKey(target))
                {
                    for(int idx : map.get(target))
                    {
                        if(idx > j)
                        {
                            List<Integer> al = new ArrayList<>(Arrays.asList(i , j , idx));
                           // Collections.sort(al);
                            result.add(al);
                        }
                    }
                }
            }
        }
        return result;
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends