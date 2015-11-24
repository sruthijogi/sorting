import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * A simple JFrame for visualizing sorting algorithms.
 * @author keshav (keshav@techlabeducation.com)
 */
public class Sorting extends JFrame {
	
	// Create an instance of this JFrame on run.
	public static void main(String[] args) {
		new Sorting();
	}
	
	// Constants
	private static final int WIDTH = 800;
	private static final float HUE = 0.3f;
	private static final float SATURATION = 0.7f;
	
	// Reference to the current array being drawn.
	private int[] currentArray = { 0 };
	
	/**
	 * Constructs the JFrame for the sorting animation.
	 */
	public Sorting() {
		// Create the window.
		super("visual sort");
		setSize(WIDTH, 22 + WIDTH);
		setVisible(true);
		setResizable(false);
		sort();
	}
	
	/**
	 * This is where you should add calls to your own sorting algorithms. 
	 */
	private void sort() {
		int[] numbers = randomize(40000);
		visualize(numbers);
		bubbleSort(numbers);
		//selectionSort(numbers);
		//quicksort(numbers);
	}

	/**
	 * Creates a random array of values between 0 and 255 of the given length.
	 * @param size
	 */
	private int[] randomize(int size) {
		// Create an array of that size
		int[] a = new int[size];
		// Go to each position in the array
		for (int i = 0 ; i < a.length ; i++) {
			a[i] = (int) (Math.random() * 256);
		}
		return a;
	}
	
	/**
	 * Selection sort.
	 * @param array
	 */
	private void selectionSort(int[] array) {
		for (int currentIndex = 0 ; currentIndex < array.length ; currentIndex++) {
			int min = array[currentIndex],
				minIndex = currentIndex;
			
			for (int testIndex = currentIndex + 1 ; testIndex < array.length ; testIndex++) {
				if (array[testIndex] < min) {
					min = array[testIndex];
					minIndex = testIndex;
				}
			}
			
			int save = array[currentIndex];
			array[currentIndex] = array[minIndex];
			array[minIndex] = save;
			
			visualize(array, 10);
		}
	}
	
	/**
	 * Quicksort helper.
	 */
	private void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}
	
	/**
	 * Quicksort.
	 */
	private void quicksort(int[] array, int start, int end) {
		if (start < end) {
			// Pick a center value to divide the list in half
			int pivot = array[end];
			// Go through the list and partition into two segments
			// One segment has all values less than pivot
			// The other segment has all values greater or equal
			int nextSwap = start;
			for (int checkIndex = start ; checkIndex < end ; checkIndex++) {
				// If it should be on the smaller partition
				if (array[checkIndex] <= pivot) {
					// Swap into the swap position
					int save = array[nextSwap];
					array[nextSwap] = array[checkIndex];
					array[checkIndex] = save;
					
					// Next swap goes to the position on the right
					nextSwap = nextSwap + 1;
				}
			}
			// Swap the pivot into the center position
			array[end] = array[nextSwap];
			array[nextSwap] = pivot;
			
			// Sort the partitions on the left and right
			//visualize(array, Math.min(end - start, 100));
			quicksort(array, start, nextSwap - 1);
			quicksort(array, nextSwap + 1, end);
		}
	}

	/**
	 * Bubble sort.
	 */
	private void bubbleSort(int[] array) {
		
		for (int j = 0 ; j < array.length ; j++) {
			// Go to every index in the list except the last one
			for (int i = 0 ; i < array.length - 1 ; i++) {
				if (array[i] > array[i + 1]) {
					int save = array[i];
					array[i] = array[i + 1];
					array[i + 1] = save;
				}
			}
			visualize(array, 1);
		}
		
	}
	
	/**
	 * Override the visualize method to draw the array with no delay.
	 * @param a
	 */
	public void visualize(int[] a) {
		visualize(a, 0);
	}

	/**
	 * Saves a reference to the array, then draws the visualization of the array
	 * and waits for the optional amount of time.
	 * @param a
	 * @param delay
	 */
	public void visualize(int[] a, int delay) {
		currentArray = a;
		repaint();
		
		// Optional delay
		if (delay > 0) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {}
		}
	}
	
	/**
	 * Draws each value in the array onto a square in the grid.
	 */
	public void paint(Graphics g) {
		int size = (int) Math.ceil(Math.sqrt(currentArray.length));
		int scale = WIDTH / size;
		
		// Go to each index in the array, and fill a square in the
		// animation with the brightness representing the magnitude of the value.
		for (int i = 0 ; i < currentArray.length ; i++ ) {
			g.setColor(Color.getHSBColor(HUE, SATURATION, currentArray[i] / 255f));
			g.fillRect((i % size) * scale, 22 + i / size * scale, scale, scale);
		}
	}
}
