# 344. Reverse String

## Difficulty
Easy

## Pattern
Two Pointers

## Topics
- String
- Two Pointers
- In-place Modification

## Approach
The goal is to reverse the given character array in-place without using any extra array.

Use two pointers:

- `left` starts from the beginning of the array.
- `right` starts from the end of the array.

Swap the characters at both pointers, then move:

- `left` one step to the right.
- `right` one step to the left.

Continue until the two pointers meet or cross each other.

## Algorithm
1. Initialize:
   - `left = 0`
   - `right = s.length - 1`
2. While `left < right`:
   - Swap `s[left]` and `s[right]`.
   - Increment `left`.
   - Decrement `right`.
3. The array is now reversed.
