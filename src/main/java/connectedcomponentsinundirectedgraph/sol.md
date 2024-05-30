# Solution
- Use a Disjoint-Set (Union-find) data structure
- For each edge, union them together and decrement the total count when the union is successful

# Time Complexity
- `O(Elog(V))`
  - We are doing union-find by size (without path-compression) to ensure the tree heights are balanced
  - This gives us a `log(n)` lookup time for find