# 1281. Subtract the Product and Sum of Digits of an Integer

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

The idea is to process each digit of the given number one by one.

- Extract the last digit using the modulo (`%`) operator.
- Add the digit to the running sum.
- Multiply the digit with the running product.
- Remove the last digit using integer division (`/`).
- Repeat until all digits have been processed.
- Return the difference between the product and the sum.

## Algorithm

1. Initialize:
   - `sum = 0`
   - `product = 1`
2. While `n > 0`:
   - Extract the last digit using `n % 10`.
   - Add the digit to `sum`.
   - Multiply the digit into `product`.
   - Remove the last digit using `n /= 10`.
3. Return `product - sum`.