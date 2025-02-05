
from typing import List


class Solution:
    def isPerfect(self, arr : List[int]) -> bool:
        # code here
        
        start=0 
        end = len(arr)-1
        
        while start<=end:
            
            if(arr[start]!=arr[end]):
                return False
            
            start = start+1
            end = end-1
        
        return True
        



#{ 
 # Driver Code Starts
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):

        arr = list(map(int, input().strip().split()))

        obj = Solution()
        res = obj.isPerfect(arr)

        if res:
            print("true")
        else:
            print('false')
        print("~")
# } Driver Code Ends