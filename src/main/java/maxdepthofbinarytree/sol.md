# Solution
- Base case is 0, since an null node does not have a height
- Recursively compute the max of the left and right and add 1 to the largest, which we return

# Time Complexity
- `O(n)`, as we traverse each node of the tree