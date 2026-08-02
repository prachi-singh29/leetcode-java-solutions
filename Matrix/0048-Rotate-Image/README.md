# 48. Rotate Image

## Difficulty
Medium

## Pattern
Matrix Manipulation

## Topics
- Arrays
- Matrix
- In-place Modification

## Approach
The goal is to rotate the given **n × n** matrix by **90° clockwise**.

### Brute Force Approach
- Create a new matrix of the same size.
- Traverse every element of the original matrix.
- Place each element in its rotated position using:
  - `rotated[j][n - 1 - i] = matrix[i][j]`
- Copy the rotated matrix back into the original matrix.