# 1. Two Sum

## Difficulty

Easy

## Pattern

HashMap

## Approach

Store previously visited numbers in a HashMap.

For every number:

- Calculate target - current
- Check if it exists
- Otherwise store current number

## Complexity

Time: O(n)

Space: O(n)

## Concepts Learned

- HashMap
- One-pass lookup