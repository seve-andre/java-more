# Java More
A collection of missing data structures in Java.

## What's been added?
### Range [see](https://github.com/seve-andre/java-more/blob/main/src/main/java/com/mitch/javamore/range/integer/Range.java)
Range lets you create a range of integer values that may have a step to skip certain values.
```java
Range fromOneToTen = Range.fromTo(1, 10); // creates range of [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Range oneToTen = Range.oneTo(10); // creates the same range of fromOneToTen

// you can also add a step to skip values you don't want to add to the range
Range fromOneToFifteenStep3 = Range.fromToWithStep(1, 15, 3); // creates range of [1, 4, 7, 10, 13]
Range oneToFifteenStep3 = Range.oneToWithStep(15, 3); // creates the same range of fromOneToFifteenStep3

// you can also create reversed ranges
Range fromTenToOne = Range.fromTo(10, 1); // creates range of [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Range tenDownToOne = Range.downToOne(10); // creates the same range of fromTenToOne

// you can also create negative ranges
Range negativeRange = Range.fromTo(-3, 3); // creates range of [-3, -2, -1, 0, 1, 2, 3]

// built-in evens and odds
Range evensFromZeroToTen = Range.evensFromTo(0, 10); // creates range of [0, 2, 4, 6, 8, 10]
Range evensZeroToTen = Range.evensFromZeroTo(10); // creates the same range of evensFromZeroToTen

Range oddsFromOneToTen = Range.oddsFromTo(1, 10); // creates range of [1, 3, 5, 7, 9]
Range oddsOneToTen = Range.oddsFromOneTo(10); // creates the same range of oddsFromOneToTen

// you can also reverse a current Range with reverse()
Range tenToOne = Range.oneTo(10).reverse(); // creates range of [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

// you can also stream an Range
Stream<Integer> oneToTenStream = Range.oneTo(10).stream(); // return a Stream of Integers from 1 to 10
```
