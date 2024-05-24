# Solution
- Very standard backtracking, use a hash map to store mappings for a number to the letters string

# Time Complexity
`O(n * 4^n)`, because we can have at most 4 choices of letters, the length of each output string is also at most
the length of the input string `n`.