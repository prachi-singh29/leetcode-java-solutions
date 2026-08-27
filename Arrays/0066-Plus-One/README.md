# 66. Plus One

## Difficulty
Easy

## Pattern
Array Manipulation

## Topics
- Arrays
- Math

## Approach
The given array represents a non-negative integer, where each element is a single digit.

To add one:

- Start from the last digit.
- If the digit is less than `9`, simply increment it by `1` and return the array.
- If the digit is `9`, change it to `0` and carry `1` to the previous digit.
- Continue this process until there is no carry left.

If all digits are `9`, a new array of size `n + 1` is required because the number gains an extra digit.

For example:

999 + 1 = 1000


## Algorithm
1. Traverse the array from the last index to the first.
2. If the current digit is less than `9`:
   - Increment it by `1`.
   - Return the array.
3. Otherwise:
   - Set the current digit to `0`.
   - Continue to the previous digit.
4. If the loop finishes, create a new array of size `n + 1`.
5. Set the first element to `1`.
6. Return the new array.