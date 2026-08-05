# 345. Reverse Vowels of a String

## Difficulty
Easy

## Pattern
Two Pointers

## Topics
- String
- Two Pointers

## Approach
The goal is to reverse only the vowels in the given string while keeping all non-vowel characters in their original positions.

Use the two-pointer technique:

- `start` starts from the beginning of the string.
- `end` starts from the end of the string.

Move both pointers until they point to vowels. Once both pointers are at vowels, swap them and continue moving inward.

A helper function `isVowel()` is used to check whether a character is a vowel.

## Algorithm
1. Convert the string into a character array.
2. Initialize:
   - `left = 0`
   - `right = s.length() - 1`
3. While `left < right`:
   - Move `left` forward until it points to a vowel.
   - Move `right` backward until it points to a vowel.
   - Swap the vowels.
   - Increment `left` and decrement `right`.
4. Convert the character array back into a string.
5. Return the modified string.