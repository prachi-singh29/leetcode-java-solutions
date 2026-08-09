# 49. Group Anagrams

## Difficulty
Medium

## Pattern
Hashing

## Topics
- Array
- String
- Hash Table
- Sorting

## Approach
The goal is to group strings that are anagrams of each other.

Two strings are anagrams if they contain the same characters with the same frequencies.

For example:
["eat", "tea", "tan", "ate", "nat", "bat"]

The anagram groups are:
["eat", "tea", "ate"]
["tan", "nat"]
["bat"]

To identify which strings are anagrams, we can sort the characters of each string.

For example:
eat → aet
tea → aet
ate → aet

Since all three strings produce the same sorted representation, they belong to the same group.

We use a `HashMap` where:
- **Key** = sorted version of the string
- **Value** = list of strings having that key

## Algorithm
1. Create a `HashMap<String, List<String>>`.
2. Traverse every string in the input array.
3. Convert the string into a character array.
4. Sort the character array.
5. Convert the sorted character array back into a string.
6. Use the sorted string as the key in the HashMap.
7. Add the original string to the corresponding list.
8. After processing all strings, return all the values from the HashMap.