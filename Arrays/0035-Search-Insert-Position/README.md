# 35. Search Insert Position

## Difficulty
Easy

## Pattern
Binary Search

## Topics
- Array
- Binary Search

## Approach
The array is sorted in ascending order.

The goal is to find the index of the `target` if it exists. If it does not exist, we need to return the index where it should be inserted while maintaining the sorted order.

The key observation is:

> Find the first index where `nums[i] >= target`.

Since the array is sorted, we can use **Binary Search** instead of checking every element one by one.

At each step:

- If `nums[mid] < target`, the target must be to the right of `mid`.
- If `nums[mid] >= target`, `mid` could be the answer, so we continue searching on the left side.

When the binary search ends, `left` represents the correct insertion position.

## Algorithm

1. Initialize:
   left = 0
   right = nums.length - 1
2. While `left <= right`:
   - Calculate the middle index:
     - mid = left + (right - left) / 2
   - If `nums[mid] < target`:
     - Move `left` to `mid + 1`.
   - Otherwise:
     - Move `right` to `mid - 1`.
3. When the loop ends, return `left`.