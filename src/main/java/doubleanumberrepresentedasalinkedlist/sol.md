# Solution
- Rather than use a stack, recursively traverse the list and evaluate as you unwind
- Return the carry as a variable
- If the carry is not 0, then we need to initialise a new head with the carry

# Time Complexity
`O(n)` for traversing the entire list