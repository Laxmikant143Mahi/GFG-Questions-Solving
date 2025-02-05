#User function Template for python3

class Solution:
    def reverseString(self, s: str) -> str:
        # Convert the string to a list to perform swapping
        char_list = list(s)
        
        start = 0
        end = len(char_list) - 1

        while start < end:
            # Swap characters
            char_list[start], char_list[end] = char_list[end], char_list[start]
            
            # Move the pointers
            start = start+1
            end = end-1

        # Join the list back into a string and return
        return ''.join(char_list)

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while (t > 0):
        s = input()
        ob = Solution()
        print(ob.reverseString(s))
        t = t - 1

        print("~")

# } Driver Code Ends