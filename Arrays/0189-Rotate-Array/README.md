# 189. Rotate Array

## Difficulty
Medium

## Pattern
Array Manipulation

## Topics
- Arrays
- Two Pointers
- In-place Modification

## Approach
The goal is to rotate the array to the right by `k` steps.

### Brute Force Approach
Rotate the array one step to the right, `k` times.

For each rotation:

1. Store the last element.
2. Shift all elements one position to the right.
3. Place the stored element at the beginning.

Although simple to understand, this approach performs unnecessary repeated shifts, making it inefficient for large values of `k`.

### Optimal Approach (Reverse Algorithm)
The optimal solution uses the reverse technique.

1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n - k` elements.

Before performing these operations, calculate:

java
k = k % n;

This handles cases where `k` is greater than the length of the array.

## Algorithm

### Brute Force
1. Find the length of the array.
2. Compute `k % n`.
3. Repeat `k` times:
   - Store the last element.
   - Shift every element one position to the right.
   - Place the stored element at index `0`.

### Optimal
1. Find the length of the array.
2. Compute `k % n`.
3. Reverse the entire array.
4. Reverse the first `k` elements.
5. Reverse the remaining `n - k` elements.