# Solution
- Base Cases
  - List is an empty or single list i.e `start == end`, return null or the empty list respectively
- Divide
  - Split the indexes of the list into two halves and recursively call `merge`
    - we calculate a half by `start + (end - start) / 2` to avoid integer overflow
- Conquer
  - Merge the two sorted lists together using a similar algorithm to merge sort's conquer step

# Time Complexity
- We divide the list by `k / 2` each time, which gives us a depth of `log(k)`
- The merge step takes linear time
- Thus, we end up with a worst-case time complexity of `O(nlog(k))`