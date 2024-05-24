# Solution
- Base Cases
  - `dp[0] = cost[0]`
  - `dp[1] = cost[1]`
- Recurrence
  - For i >= 2 up to n
  - `dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i]`
- Final Solution
  - `min(dp[n - 1], dp[n - 2])`
    - This is because we can skip the nth set of stairs (by jumping)

# Time Complexity
- n subproblems solved in constant time for `O(n)`.