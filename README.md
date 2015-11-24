# Sorting

This is a simple JFrame for demonstrating sorting algorithms. The current implementation has bubble sort, selection sort, and quicksort, and it is fairly straightforward to implement others and add points where the array can be redrawn to animate the sorting.

## Easiest setup (no IDE)

```
git clone https://github.com/techlabeducation/sorting
cd sorting
javac Sorting.java
java Sorting -algorithm quick -width 800
```

## Some examples

Bubble sort 100 numbers.
```
java Sorting -algorithm bubble -size 100
```

Quicksort 6400 numbers.
```
java Sorting -algorithm quick -size 6400
```
