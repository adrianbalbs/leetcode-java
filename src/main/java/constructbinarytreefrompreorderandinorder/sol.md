# Solution
- The first node in preorder is guaranteed to be the root
- The nodes to the left of the root in inorder will be the left subtree, the nodes to the right are the right subtree
- We use divide and conquer to recursively build the tree by partitioning the inorder array
- Similarly, we partition the preorder array

# Time Complexity
- `O(n)` since we construct every node, `O(n)` space complexity to use a hash map for lookup
