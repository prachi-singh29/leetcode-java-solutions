# 796. Rotate String

## Difficulty
Easy

## Pattern
String Manipulation

## Topics
- String
- Simulation
- Concatenation

## Approach
A string can be rotated by repeatedly moving its first character to the end.

Instead of performing every possible rotation manually, concatenate the original string with itself.

If `goal` is a rotation of `s`, then it will always appear as a substring of `s + s`.

Before checking this condition, ensure that both strings have the same length. If their lengths differ, they can never be rotations of each other.

## Algorithm
1. If the lengths of `s` and `goal` are different, return `false`.
2. Concatenate the string with itself:
   - `temp = s + s`
3. Check whether `goal` is a substring of `temp`.
4. Return the result.