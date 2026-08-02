# 867. Transpose Matrix

## Difficulty
Easy

## Pattern
Matrix Manipulation

## Topics
- Arrays
- Matrix
- Simulation

## Approach
The transpose of a matrix is obtained by swapping its rows with its columns.

- Create a new matrix with dimensions `columns × rows`.
- Traverse every element of the original matrix.
- Place each element `matrix[i][j]` at position `transpose[j][i]`.
- Return the transposed matrix.

Since the dimensions of the transposed matrix may differ from the original matrix, a new matrix is required.

## Algorithm
1. Let `m` be the number of rows and `n` be the number of columns.
2. Create a new matrix `result` of size `n × m`.
3. Traverse each element of the original matrix.
4. Assign:
   - `result[j][i] = matrix[i][j]`
5. Return the `result` matrix.