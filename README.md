This is a JFrame for demonstrating sorting algorithms to students. It is easy to play with, and is kept purposefully simple to make even beginner students feel comfortable using it.

![](http://apcs.io/img/lab/sorting/quicksort2.gif)

## Super easy setup

You don't need an IDE to run this code, just a command line.

```
git clone https://github.com/techlabeducation/sorting
cd sorting
javac Sorting.java
java Sorting
```

## Command line arguments

- `-width` - change the size of the window
- `-algorithm` - choose the sorting algorithm (currently only `bubble`, `selection`, and `quick` are included)
- `-size` - the number of elements in the integer array being sorted
- `-buffer` - animating enormous arrays can be time consuming, so you can provide a number `n` such that only every `n`th frame is shown

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

## Teaching strategy

We will usually start with a template version of the `Sorting.java` file, and implement common algorithms like bubble sort, selection sort, and quicksort as functions. Calling the `visualize` function with an array argument will generate a frame of the array visualization.

## Extending

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
