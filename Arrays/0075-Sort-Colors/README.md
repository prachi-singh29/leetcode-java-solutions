# 75. Sort Colors

## Approaches

### Approach 1: Arrays.sort()

- Time: O(n log n)
- Space: O(log n) (implementation dependent)

Useful for quick implementation but does not satisfy the interview's optimal solution requirement.

### Approach 2: Dutch National Flag Algorithm (Implemented as Main Solution)

- Time: O(n)
- Space: O(1)

Uses three pointers (`low`, `mid`, `high`) to partition the array in a single pass.

## Preferred Solution

The Dutch National Flag algorithm is preferred because it meets the problem's optimal time and space constraints.