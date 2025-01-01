//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Map to store sorted string as the key and list of anagrams as the value
        Map<String, ArrayList<String>> map = new HashMap<>();

        // Iterate over each string in the input array
        for (String str : arr) {
            // Convert the string to a character array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            // Use the sorted string as a key
            String key = new String(chars);

            // If the key is not already in the map, add a new list
            map.putIfAbsent(key, new ArrayList<>());

            // Add the original string to the list associated with the key
            map.get(key).add(str);
        }

        // Convert the values of the map into an ArrayList of ArrayLists
        return new ArrayList<>(map.values());
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends