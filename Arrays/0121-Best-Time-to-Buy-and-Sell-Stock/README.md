# 121. Best Time to Buy and Sell Stock

## Difficulty
Easy

## Pattern
Greedy / Array Traversal

## Topics
- Arrays
- Greedy
- Dynamic Programming

## Approach
The goal is to find the maximum profit that can be made by buying a stock on one day and selling it on a later day.

We need to:
- Buy at the **lowest price seen so far**.
- Sell at the current price.
- Calculate the profit.
- Keep track of the maximum profit.

Instead of checking every possible pair of buy and sell days, we can traverse the array only once.

For every price:
profit = current price - minimum price so far

Then update the maximum profit.

## Algorithm
1. Initialize `minPrice` to a very large value.
2. Initialize `maxProfit` to `0`.
3. Traverse the array.
4. For each price:
   - Update `minPrice` if the current price is smaller.
   - Calculate the profit if we sell at the current price.
   - Update `maxProfit`.
5. Return `maxProfit`.