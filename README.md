# DAA Assignment 1

Assignment 1 for Design and Analysis of Algorithms.

The project implements three Divide and Conquer algorithms in Java:

- MergeSort
- QuickSort
- QuickSelect

The project also contains performance metrics, benchmark tests and JUnit 5 tests.

## Requirements

- Java 17
- Maven
- IntelliJ IDEA

Algorithms
MergeSort
Uses one reusable helper array.
Uses Insertion Sort when the subarray size is 15 or less.
Merge operation works in linear time.
QuickSort
Uses a random pivot.
Uses 3-way partitioning.
Recursively processes the smaller side first.
Processes the larger side with a loop to keep recursion depth small.
QuickSelect
Uses the same 3-way partition as QuickSort.
Continues only in the part that contains index k.
Throws IllegalArgumentException for invalid input.
Tests

The project uses JUnit 5.

Run tests with:

mvn clean test

The tests check:

sorting against Arrays.sort;
empty arrays;
one element;
equal elements;
already sorted arrays;
QuickSort recursion depth;
QuickSelect correctness.
Benchmark

Run Benchmark.java in IntelliJ IDEA.

The benchmark tests:

n = 1,000
n = 10,000
n = 100,000
n = 1,000,000

Input types:

random
sorted
duplicates

Every case is executed 5 times and the median result is saved.

The benchmark creates:

results.csv

CSV columns:

algorithm,input,n,time_ms,comparisons,max_depth
Plots

The repository contains:

time_vs_n.png
depth_vs_n.png
ratio_vs_n.png

## Project Structure

```text
src/main/java/
    Metrics.java
    MergeSort.java
    Partition3Way.java
    QuickSort.java
    QuickSelect.java
    Benchmark.java

src/test/java/
    AlgorithmsTest.java
