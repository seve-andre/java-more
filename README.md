# Java More
A collection of missing data structures in Java.

## What's been added?
### IntRange [see](https://github.com/seve-andre/java-more/blob/main/src/main/java/com/mitch/javamore/range/integer/IntRange.java)
IntRange lets you create a range of integer values that may have a step to skip certain values.
```java
IntRange fromOneToTen = IntRange.fromTo(1, 10); // creates range of [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
IntRange oneToTen = IntRange.oneTo(10); // creates the same range of fromOneToTen

// you can also add a step to skip values you don't want to add to the range
IntRange fromOneToFifteenStep3 = IntRange.fromToWithStep(1, 15, 3); // creates range of [1, 4, 7, 10, 13]
IntRange oneToFifteenStep3 = IntRange.oneToWithStep(15, 3); // creates the same range of fromOneToFifteenStep3

// you can also create reversed ranges
IntRange fromTenToOne = IntRange.fromTo(10, 1); // creates range of [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
IntRange tenDownToOne = IntRange.downToOne(10); // creates the same range of fromTenToOne

// you can also create negative ranges
IntRange negativeRange = IntRange.fromTo(-3, 3); // creates range of [-3, -2, -1, 0, 1, 2, 3]

// built-in evens and odds
IntRange evensFromZeroToTen = IntRange.evensFromTo(0, 10); // creates range of [0, 2, 4, 6, 8, 10]
IntRange evensZeroToTen = IntRange.evensFromZeroTo(10); // creates the same range of evensFromZeroToTen

IntRange oddsFromOneToTen = IntRange.oddsFromTo(1, 10); // creates range of [1, 3, 5, 7, 9]
IntRange oddsOneToTen = IntRange.oddsFromOneTo(10); // creates the same range of oddsFromOneToTen

// you can also reverse a current IntRange with reverse()
IntRange tenToOne = IntRange.oneTo(10).reverse(); // creates range of [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

// you can also stream an IntRange
Stream<Integer> oneToTenStream = IntRange.oneTo(10).stream(); // return a Stream of Integers from 1 to 10
```
