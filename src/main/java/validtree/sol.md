# Solution
- Union-find (because I am too lazy to make the graph myself)
- Aside from the cyclic case, we also need to make sure the number of connected components is 1
- Alternatively could use DFS with graph construction via adjacency list, keep track of prev node

# Time Complexity
- `O(ElogV)`