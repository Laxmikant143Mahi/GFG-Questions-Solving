//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function is to check whether two strings are anagram of each other or not.
    bool areAnagrams(string a, string b){
        
        // Your code here
        
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        
        return a==b;
        
        
        
    }

};


//{ Driver Code Starts.

int main() {

    int t;

    cin >> t;

    while (t--) {
        string c, d;

        cin >> c >> d;
        Solution obj;
        if (obj.areAnagrams(c, d))
            cout << "true" << endl;
        else
            cout << "false" << endl;
        cout << "~" << endl;
    }
}

// } Driver Code Ends