# Solution
- Have a global to store diameter
- Use a dfs to recursively record the depth of the tree
- The base case will be -1 instead of 0 (when we return, evaluating will have a single node be 0)
  - This is because there are 0 edges from the leaf
- Diameter is calculated by `max(diameter, left + right + 2)`.
  - We add by 2 to cancel out the -1's on the left and right
    - E.g. for a leaf node, both left and right will be -1, so (-1) + (-1) + 2 = 0, which is the
    correct diameter
    - Returning upwards would yield 0 as well for a root with a leaf

# Time Complexity
- `O(n)` worst case since we DFS