# 54. Spiral Matrix

## Difficulty
Medium

## Pattern
Matrix Traversal

## Topics
- Arrays
- Matrix
- Simulation

## Approach
Traverse the matrix layer by layer in a spiral order using four boundaries:
- `top` → First unvisited row
- `bottom` → Last unvisited row
- `left` → First unvisited column
- `right` → Last unvisited column

At each iteration:
1. Traverse from left to right along the top row.
2. Move the `top` boundary down.
3. Traverse from top to bottom along the right column.
4. Move the `right` boundary left.
5. If rows remain, traverse from right to left along the bottom row.
6. Move the `bottom` boundary up.
7. If columns remain, traverse from bottom to top along the left column.
8. Move the `left` boundary right.

Repeat until all elements have been visited.

## Algorithm
1. Initialize four boundaries:
   - `top = 0`
   - `bottom = rows - 1`
   - `left = 0`
   - `right = columns - 1`
2. While `top <= bottom` and `left <= right`:
   - Traverse the top row.
   - Increment `top`.
   - Traverse the right column.
   - Decrement `right`.
   - If `top <= bottom`, traverse the bottom row.
   - Decrement `bottom`.
   - If `left <= right`, traverse the left column.
   - Increment `left`.
3. Return the list containing the spiral order traversal.
