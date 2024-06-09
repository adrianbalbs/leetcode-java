# Solution
- Two cases of sortedness
  - If left up to middle is sorted, then the right half isn't sorted
    - If the target is greater than the middle or the target is less than the left, then search right, otherwise search left
  - The right is sorted
    - If the target is smaller than the middle, or the target is greater than the right, then search left, otherwise search right

# Time Complexity
- `O(logn)`