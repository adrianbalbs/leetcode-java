# Solution
- Solve in increasing length of string `j - i > 1`
- If `s[i] == s[j] && opt[i + 1][j - 1]` then record the start and end indexes
- This algorithm works since we compute in increasing length, and thus, for each palindrome found at each length, we record
    the longest palindrome

# Time Complexity
- `O(n^2)`