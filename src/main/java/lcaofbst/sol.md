# Solution
- Keep in mind that we are in a BST
- Two cases:
  - root.val > p.val and root.val > q.val, then we search left for the LCS
  - root.val < p.val and root.val < q.val, then we search right for the LCS
  - If any of these conditions are not fulfilled, then we can return the node

# Time Complexity 
- `O(log(n))` since we are always dividing the search space through binary search