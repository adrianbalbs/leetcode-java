# Solution
- Use DP, check if the next word from `s[j..i]` is in the dict and if `valid[j]` is true
- Base case is when `valid[0] = true`

# Time Complexity
- `O(n^2)`, currently using substring which makes the time complexity slower than it needs to