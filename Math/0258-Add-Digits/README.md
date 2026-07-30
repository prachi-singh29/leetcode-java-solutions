# 258. Add Digits

## Difficulty
Easy

## Pattern
Math

## Topics
- Math
- Number Manipulation
- Digit Extraction
- Simulation

## Approach
The idea is to repeatedly calculate the sum of the digits of the given number until the result becomes a single-digit number.
- Extract each digit using the modulo (`%`) operator.
- Add the digits together.
- Replace the original number with the calculated sum.
- Repeat the process until the number has only one digit.
- Return the final single-digit value.

## Algorithm
1. While the number has more than one digit (`n >= 10`):
   - Initialize `sum = 0`.
   - Extract each digit using `n % 10`.
   - Add the digit to `sum`.
   - Remove the last digit using `n /= 10`.
   - Assign `n = sum`.
2. Return `n`.
