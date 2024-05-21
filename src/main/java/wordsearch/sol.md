# Solution
- Recursive Backtracking DFS
- We only dfs when the starting letter is found
- False when we hit boundary cases, or when the letter isn't equal, or the letter
    has been visited
- Make sure to unmark `board[i][j]` as visited after the dfs to prevent the 
    dfs from terminating early on another iteration

# Time Complexity
`O(m * n * 3^L)` where L is the length of the word