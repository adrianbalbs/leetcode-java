# Solution
- Base cases `dp[0] = 1` there is only 1 way to decode the empty string, `dp[1] = if s[1] = 0 then 0 else 1`
- Recurrence
- If `s[i - 1] != 0` then `dp[i] += dp[i - 1]`
- If `s[i - 2] == 1 or s[i - 2] == 2 and 0 <= s[i - 1] < 7` then `dp[i] += dp[i - 2]`

# Time Complexity
`O(n)`