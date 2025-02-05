#User function Template for python3

class Solution:
	def countOddEven(self, arr):
		#Code here
		odd = 0
		even = 0
	    for element in arr:
	        if(element%2!=0):
	            odd = odd+1
	        else:
	            even = even+1
	            
	    list1 = [odd,even]
	    return list1
	       


#{ 
 # Driver Code Starts
if __name__ == "__main__":
    # Testcase input
    testcase = int(input())

    for _ in range(testcase):

        arr = list(map(int, input().split()))

        # Creating an object of the Solution class
        ob = Solution()

        # Calling the function to count even and odd
        res = ob.countOddEven(arr)

        # Printing the result
        print(*res)
        print("~")

# } Driver Code Ends