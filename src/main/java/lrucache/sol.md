# Solution
- Use `HashMap<Integer, ListNode>`, where `ListNode` is a doubly linked-list node.
- Have two dummy nodes to represent the `lru` and the `mru`, they 
will initially be pointing to each other at initialisation time
- Have helpers to handle removing and inserting into the linked list
  - Doubly Linked Lists makes the insertion/deletion process much easier, becomes a matter of pointer manipulation
  - It is key to have a constant time complexity.

# Time Complexities
- Put `O(1)`
- Get `O(1)`