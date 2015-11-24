# Sorting

This is a simple JFrame for demonstrating sorting algorithms. The current implementation has bubble sort, selection sort, and quicksort, and it is fairly straightforward to implement others and add points where the array should be redrawn to animate the sorting.

![](https://gyazo.com/ab625b939a1c8f40eeaf04e86dfd201b)

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

Selection sort 6400 numbers.
```
java Sorting -algorithm selection -size 6400
```

Quicksort 640,000 numbers (notice the `-buffer` parameter to speed up the animation by only showing every 1000th frame)
```
java Sorting -algorithm quick -size 640000 -buffer 1000
```
