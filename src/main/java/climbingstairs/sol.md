# Solution
- Base Cases:
  - `opt(0) = opt(1) = 1`
- Recurrence
  - For `i >= 2` up to `n`
    - `opt(i) = opt(i - 1) + opt(i - 2)`

# Time Complexity
- O(n) with O(n) Space