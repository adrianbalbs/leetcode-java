### Solution
- Enumeration DP problem, solve similar to how we would do it if backtracking
- Base Case is `dp(0) = 1`, there is only 1 way to make up an amount of 0, with no coins at all
### Recurrence
```
    For increasing 0 <= k < coins.length then 0 < i <= amount:
    dp(i) = dp(i) + dp(i - coins[k]) if coins[k] <= i else dp[i]
```

The order of computation here works because we only consider the coin once
for the combination, having it the other way around leads to over counting because
we are counting different permutations of the same combination of coins.

### Time Complexity
`O(nC)` where n is the amount and C is the number of coins