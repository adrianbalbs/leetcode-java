# Solution
- Easily done with a pre-order traversal
- Maintain a list of nodes and join with "," at the end
  - Initially did concatenation, but it is a lot slower since linear time operation
- Deserializing involves maintaining an index in the List and doing pre-order traversal again
  - Return null for null nodes

# Time Complexity
`O(n)` operation, `O(n)` space since we are maintaining a list.