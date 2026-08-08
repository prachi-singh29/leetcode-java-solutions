# 1619. Mean of Array After Removing Some Elements

## Difficulty
Easy

## Pattern
Sorting

## Topics
- Arrays
- Sorting
- Math

## Approach
The goal is to find the mean of the array after removing:

- The smallest `5%` of the elements.
- The largest `5%` of the elements.

Since the array size is always a multiple of `20`, we can calculate the number of elements to remove as:

```java
int remove = arr.length / 20;
```

First, sort the array.

After sorting:

- The first `remove` elements are the smallest `5%`.
- The last `remove` elements are the largest `5%`.

We then calculate the sum of the remaining elements and divide it by their count.

## Algorithm
1. Sort the array.
2. Calculate the number of elements to remove:
   ```java
   int remove = arr.length / 20;
   ```
3. Start from index `remove`.
4. Stop before index `arr.length - remove`.
5. Add all remaining elements to the sum.
6. Calculate the mean:
   ```java
   mean = sum / count;
   ```
7. Return the result as a `double`.