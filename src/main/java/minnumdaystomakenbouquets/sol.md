# Solution
- Binary search on the range `0..D` where `D` is the max day in `bloomDay`
- We run a subroutine where we check if we can make m bouquets with k adjacent flowers on day `d = l + (r - l) / 2` through a linear sweep and running sum
  - if `bloomDay[i] <= d` incr the counter, if the counter hits `k`, then reset to 0 and decrement `m`
  - Otherwise, reset the counter back to 0
  - At any point where `m == 0` we can break and return true
  - Otherwise, return false
- If our subroutine returns true we search in the range `0..d - 1`, otherwise we search on the range `d + 1..D`.
- If we cannot find a day where we can make `m` bouquets from `k` adjacent flowers, then return -1