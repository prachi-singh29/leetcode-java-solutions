# 27. Remove Element

## Difficulty

Easy

## Pattern

Two Pointers

## Topics

- Arrays
- Two Pointers
- In-place Modification

## Approach

The goal is to remove all occurrences of the given value from the array without using extra space.

- Use two pointers:
  - `i` keeps track of the position where the next valid element should be placed.
  - `j` traverses the array.
- If `nums[j]` is not equal to `val`, copy it to `nums[i]` and increment `i`.
- After traversing the array, the first `i` elements contain all the elements except `val`.

## Algorithm

1. Initialize `i = 0`.
2. Traverse the array using `j`.
3. If `nums[j] != val`:
   - Assign `nums[i] = nums[j]`.
   - Increment `i`.
4. Return `i` as the new length of the array.
