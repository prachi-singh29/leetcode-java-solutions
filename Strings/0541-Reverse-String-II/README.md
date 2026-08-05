# 541. Reverse String II

## Difficulty
Easy

## Pattern
Two Pointers

## Topics
- String
- Two Pointers
- Simulation

## Approach
The problem requires reversing the first `k` characters for every block of `2k` characters in the string.

To solve this efficiently:

1. Convert the string into a character array since Java strings are immutable.
2. Traverse the array in steps of `2k`.
3. For each block:
   - Reverse the first `k` characters.
   - Leave the next `k` characters unchanged.
4. Convert the modified character array back into a string.

If fewer than `k` characters remain, reverse all of them.

If there are between `k` and `2k` characters remaining, reverse only the first `k` characters and leave the rest unchanged.

## Algorithm
1. Convert the input string into a character array.
2. Iterate through the array with a step size of `2 * k`.
3. For each iteration:
   - Set:
     - `left = i`
     - `right = min(i + k - 1, n - 1)`
   - Reverse the characters between `left` and `right`.
4. Convert the character array back into a string.
5. Return the result.