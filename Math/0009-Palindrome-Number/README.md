# 9. Palindrome Number

## Difficulty

Easy

## Pattern

Math

## Topics

- Math
- Number Manipulation
- Integer Reversal

## Approach

A palindrome number reads the same forward and backward.

- Negative numbers cannot be palindromes because they start with a negative sign.
- Reverse the given integer by extracting one digit at a time.
- Compare the reversed number with the original number.
- If both are equal, the number is a palindrome.

## Algorithm

1. If `x < 0`, return `false`.
2. Store the original value of `x`.
3. Initialize `reverse = 0`.
4. While `x > 0`:
   - Extract the last digit using `x % 10`.
   - Append it to `reverse`.
   - Remove the last digit using `x /= 10`.
5. Compare `reverse` with the original number.
6. Return `true` if they are equal; otherwise, return `false`.
