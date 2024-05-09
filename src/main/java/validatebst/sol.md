# Solution
- Check that `min < root < max`
  - When recursing the left: set the rightmost bound to the root
  - When recursing to the right: set the leftmost bound to the root
- This is to satisfy the properties of a BST
  - The leftmost nodes must be less than the root
  - The rightmost nodes must be greater than the root
- Can't use Infinity for Integers, so have to use null as a hack
# Time Complexity
- `O(n)`