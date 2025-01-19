#User function Template for python3
class Solution:
	def arraySum(self, arr):
   		# code here
   		sum=0
   		for a in arr: 
   		    sum+=a
   		return sum



#{ 
 # Driver Code Starts
# Driver code
if __name__ == "__main__":
    tc = int(input())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.arraySum(arr)
        print(ans)
        tc = tc - 1
        print("~")

# } Driver Code Ends