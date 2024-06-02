# Solution
- Recurrence is opt(i) = min(opt(i - C) + 1, opt(i)), where i - C >= 0
- Base case is opt(0) = 0

# Time Complexity
- `O(nC)` where C is the number of coins