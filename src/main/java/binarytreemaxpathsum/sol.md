# Solution
- A few cases to consider
  - We return the path if we are not allowed to split up to the parent
  - From the root node, we should calculate the cost of going left and right + the root (splitting)
    - This will be stored in the global variable and will be compared to the current minimum
  - We discard negatives returned from the left or right

# Time Complexity
`O(n)` since we visit every node at least once.