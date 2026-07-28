# 202. Happy Number

## Difficulty
Easy

## Pattern
Hashing / Cycle Detection

## Topics
- Hash Table
- Math
- Cycle Detection
- Number Manipulation

## Approach
A happy number is obtained by repeatedly replacing the number with the sum of the squares of its digits until:

- The number becomes `1` (Happy Number), or
- The process enters a cycle (Not a Happy Number).

To detect a cycle, maintain a `HashSet` of previously visited numbers.

- If the current number is already present in the set, a cycle has been detected.
- If the number becomes `1`, return `true`.

## Algorithm
1. Create an empty `HashSet`.
2. While the current number is not `1`:
   - If the number already exists in the set, return `false`.
   - Add the current number to the set.
   - Calculate the sum of the squares of its digits.
3. Return `true`.