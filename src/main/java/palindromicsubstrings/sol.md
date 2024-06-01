# Solution
- Use DP bottom-up, computing by decreasing i and increasing j where 0 <= i <= j <= len
- Base cases are where i == j and s[i] == s[i + 1], these are palindromes

# Time Complexity
- `O(n^2)` since subproblems are computed decreasing i and increasing j, and take `O(n)` time to complete
- Using a 2d grid gives us `O(n^2)` space as part of the cost for using DP