#User function Template for python3
class Solution:
    def missingNumber(self, arr):
        n = len(arr)+1
        total_sum = n*(n+1)//2
        
        sum1 = sum(arr)
        
        diff = total_sum-sum1
        return diff
                


#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int(input())
for _ in range(0, t):
    arr = list(map(int, input().split()))
    s = Solution().missingNumber(arr)
    print(s)

    print("~")
# } Driver Code Ends