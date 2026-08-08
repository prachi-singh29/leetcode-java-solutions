# 58. Length of Last Word

## Difficulty
Easy

## Pattern
String Traversal

## Topics
- String
- String Traversal

## Approach
The goal is to find the length of the last word in a string.

A word is a sequence of non-space characters.

The string may contain spaces at the end, so we first skip all trailing spaces. Then, we count the characters of the last word until we reach another space or the beginning of the string.

Instead of splitting the entire string into multiple words, we can traverse it from right to left and find the last word directly.

## Algorithm
1. Start from the last character of the string.
2. Skip any trailing spaces.
3. Start counting characters once the last word is found.
4. Continue moving left until a space is encountered or the beginning of the string is reached.
5. Return the count.