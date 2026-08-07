# 1572. Matrix Diagonal Sum

## Difficulty
Easy

## Pattern
Matrix Traversal

## Topics
- Arrays
- Matrix

## Approach
The goal is to find the sum of the primary and secondary diagonals of a square matrix.

- The **primary diagonal** consists of elements where `row == column`.
- The **secondary diagonal** consists of elements where `row + column == n - 1`.

Traverse the matrix once:

- Add the primary diagonal element `mat[i][i]`.
- Add the secondary diagonal element `mat[i][n - 1 - i]`.

If the matrix has an **odd** size, the center element belongs to both diagonals and gets added twice. To avoid double counting, subtract the center element once.

## Algorithm
1. Initialize `sum = 0`.
2. Traverse each row from `0` to `n - 1`.
3. Add the primary diagonal element:
   - `mat[i][i]`
4. Add the secondary diagonal element:
   - `mat[i][n - 1 - i]`
5. If `n` is odd:
   - Subtract the center element `mat[n / 2][n / 2]`.
6. Return `sum`.
