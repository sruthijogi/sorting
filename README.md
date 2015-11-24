# Sorting

This is a simple JFrame for demonstrating sorting algorithms. The current implementation has bubble sort, selection sort, and quicksort, and it is fairly straightforward to implement others and add points where the array should be redrawn to animate the sorting.

![](http://apcs.io/img/lab/sorting/quicksort.gif)

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

![](http://apcs.io/img/lab/sorting/bubblesort.gif)

Quicksort 6400 numbers.
```
java Sorting -algorithm quick -size 6400
```

![](http://apcs.io/img/lab/sorting/quicksort2.gif)

Selection sort 6400 numbers.
```
java Sorting -algorithm selection -size 6400
```

![](http://apcs.io/img/lab/sorting/selection.gif)

Quicksort 640,000 numbers (notice the `-buffer` parameter to speed up the animation by only showing every 1000th frame)
```
java Sorting -algorithm quick -size 640000 -buffer 1000
```
