# 118. Pascal's Triangle

## Difficulty
Easy

## Pattern
Array / Dynamic Programming

## Topics
- Array
- Dynamic Programming
- Math

## Approach
Pascal's Triangle is a triangular arrangement of numbers where:

- The first and last element of every row is `1`.
- Every element between them is calculated by adding the two numbers directly above it.

For example:
        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1


For example, to calculate `3`:
1 2 1
  ↑ ↑
 1 + 2 = 3

Similarly:
2 + 1 = 3

So the next row becomes:
1 3 3 1

## Algorithm
1. Create an empty `List<List<Integer>>` to store the triangle.
2. Repeat for each row from `0` to `numRows - 1`.
3. Create a new list for the current row.
4. Add `1` as the first element.
5. For elements between the first and last position:
   - Add the two values from the previous row.
6. Add `1` as the last element if the row has more than one element.
7. Add the current row to the result.
8. Return the result.