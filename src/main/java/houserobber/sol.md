# Solution
- We can either not rob the ith house if we've robbed i - 1, or we can rob the ith house if we've robbed i - 2
- The recurrence is opt(i) = max(opt(i - 1), opt(i - 2) + h[i])
- Base cases are opt(0) = h[0], opt(1) = max(h[0], h[1])

# Time Complexity
- `O(n)`