# Sorting

This is a simple JFrame for demonstrating sorting algorithms. The current implementation has bubble sort, selection sort, and quicksort, and it is fairly straightforward to implement others and add points where the array should be redrawn to animate the sorting.

![](http://apcs.io/img/lab/sorting/quicksort.gif)

## Easiest setup (no IDE)

```
git clone https://github.com/techlabeducation/sorting
cd sorting
javac Sorting.java
java Sorting
```

## Options

`-width` - change the size of the window
`-algorithm` - choose the sorting algorithm (currently only `bubble`, `selection`, and `quick` are included)
`-size` - the number of elements in the integer array being sorted
`-buffer` - animating enormous arrays can be time consuming, so you can provide a number `n` such that only every `n`th frame is shown

## Examples

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

# Extending

Contributions are welcome, especially from [techlab](https://techlab.education) students! Here are some sorting algorithms on the todo list:

- [insertion sort](http://sorting-algorithms.com/insertion-sort)
- [shell sort](http://sorting-algorithms.com/shell-sort)
- [merge sort](http://sorting-algorithms.com/merge-sort)
- [heap sort](http://sorting-algorithms.com/heap-sort)
- [quick3](http://sorting-algorithms.com/quick-sort-3-way)
- [dual-pivot quicksort](http://permalink.gmane.org/gmane.comp.java.openjdk.core-libs.devel/2628)
- [comb sort](https://en.wikipedia.org/wiki/Comb_sort)
- [radix sort](https://en.wikipedia.org/wiki/Radix_sort)
- [bogo sort](https://en.wikipedia.org/wiki/Bogosort)
- [American flag sort](https://en.wikipedia.org/wiki/American_flag_sort)
