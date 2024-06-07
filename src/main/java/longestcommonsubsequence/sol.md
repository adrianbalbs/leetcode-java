# Solution
- Solve in increasing n and m
- Base cases when either string is empty, then `dp[0][j]` and `dp[i][0]` are 0
- if both match then `dp[i][j] = dp[i - 1][j - 1] + 1`
- Else `dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]`, we want to take the longest match