# 26. Remove Duplicates from Sorted Array

## Difficulty
Easy

## Pattern
Two Pointers

## Topics
- Arrays
- Two Pointers
- In-place Modification

## Approach

Since the array is already sorted, duplicate elements appear next to each other.

- Use two pointers:
  - `i` points to the last unique element.
  - `j` scans the array from left to right.
- Whenever `nums[j]` is different from `nums[i]`, increment `i` and place the new unique element at `nums[i]`.
- After the traversal, the first `i + 1` elements of the array contain all unique values.

## Algorithm

1. If the array is empty, return `0`.
2. Initialize `i = 0`.
3. Iterate `j` from `1` to `n - 1`.
4. If `nums[j] != nums[i]`:
   - Increment `i`
   - Assign `nums[i] = nums[j]`
5. Return `i + 1`.

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(1)** |
