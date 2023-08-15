# Gildedrose Refactoring Kata

## Problem Description

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a prominent city ran by 
a friendly innkeeper named Allison. We also buy and sell only the finest goods. Unfortunately, our goods are 
constantly degrading in quality as they approach their sell by date. We have a system in place that updates our 
inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures. Your 
task is to add the new feature to our system so that we can begin selling a new category of items. First an 
introduction to our system:
- All items have a SellIn value which denotes the number of days we have to sell the item
- All items have a Quality value which denotes how valuable the item is
- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:
- Once the sell by date has passed, Quality degrades twice as fast
- The Quality of an item is never negative
- “Aged Brie” actually increases in Quality the older it gets
- The Quality of an item is never more than 50
- “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality
- “Backstage passes”, like aged brie, increases in Quality as its SellIn value approaches;
  - Quality increases by 2 when there are 11 days or less and by 3 when there are 6 days or less but
  - Quality drops to 0 after the concert

Refactor the code to accommodate the new feature while making sure that the existing functionality is not broken.

## Solution

Several refactorings were applied to the code to make it more readable and maintainable:
- Create constants for each integer and string value used in the code.
- A function has been created for each item with its logic to have it divided.
- Class Item becomes an abstract class and each type of item inherits from it.
  - Each item has its own logic to update its quality and sellIn.
- Also value objects have been created to separate the logic of each field of the item.