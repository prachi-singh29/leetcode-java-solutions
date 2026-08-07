# 20. Valid Parentheses

## Difficulty
Easy

## Pattern
Stack

## Topics
- Stack
- String

## Approach
The goal is to determine whether a string containing only parentheses is valid.

A string is considered valid if:

- Every opening bracket has a corresponding closing bracket.
- Brackets are closed in the correct order.
- Every closing bracket matches the most recently opened bracket.

A stack is the ideal data structure for this problem because it follows the **Last In, First Out (LIFO)** principle.

### Idea
- Traverse the string one character at a time.
- If the current character is an opening bracket (`(`, `{`, `[`), push it onto the stack.
- If the current character is a closing bracket (`)`, `}`, `]`):
  - Check if the stack is empty. If it is, return `false`.
  - Pop the top element from the stack.
  - Verify that it matches the corresponding opening bracket.
- After processing all characters, the stack should be empty for the string to be valid.

## Algorithm
1. Create an empty stack.
2. Traverse each character in the string.
3. If the character is an opening bracket:
   - Push it onto the stack.
4. Otherwise:
   - If the stack is empty, return `false`.
   - Pop the top element.
   - Check whether it matches the current closing bracket.
   - If not, return `false`.
5. After the loop, return `true` if the stack is empty; otherwise, return `false`.