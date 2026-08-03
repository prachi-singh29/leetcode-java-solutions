# 59. Spiral Matrix II

## Difficulty
Medium

## Pattern
Matrix Traversal

## Topics
- Arrays
- Matrix
- Simulation

## Approach
The goal is to generate an `n × n` matrix filled with numbers from `1` to `n²` in spiral order.

Maintain four boundaries:
- `top` → First unfilled row
- `bottom` → Last unfilled row
- `left` → First unfilled column
- `right` → Last unfilled column

At each iteration:
1. Fill the top row from left to right.
2. Move the `top` boundary down.
3. Fill the right column from top to bottom.
4. Move the `right` boundary left.
5. If rows remain, fill the bottom row from right to left.
6. Move the `bottom` boundary up.
7. If columns remain, fill the left column from bottom to top.
8. Move the `left` boundary right.

Repeat until all numbers from `1` to `n²` have been placed.

## Algorithm
1. Create an `n × n` matrix.
2. Initialize:
   - `top = 0`
   - `bottom = n - 1`
   - `left = 0`
   - `right = n - 1`
   - `num = 1`
3. While `top <= bottom` and `left <= right`:
   - Fill the top row.
   - Increment `top`.
   - Fill the right column.
   - Decrement `right`.
   - If `top <= bottom`, fill the bottom row.
   - Decrement `bottom`.
   - If `left <= right`, fill the left column.
   - Increment `left`.
4. Return the generated matrix.