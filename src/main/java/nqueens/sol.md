# Solution
- Backtracking again
- Queens move horizontally, vertically, and diagonally
- When we place a queen we can skip to the next row (since we can't be on same row)
- Note that for the positive and negative diagonals, row + col, and col + row respectively remain consistent throughout the board
  - We can keep track of the position of the previous queen using three sets
- Then, the question boils down to a standard backtracking algorithm

# Time Complexity
- `O(n!)`