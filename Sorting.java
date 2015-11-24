
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
		
		int size = 10000;
		int width = 800;
		int speed = 1;
		int buffer = 1;
		
		String algorithm = "quick";
		for (int i = 0 ; i < args.length ; i++) {
			if (args[i].equals("-algorithm") && i + 1 < args.length)
				algorithm = args[i + 1].toLowerCase()
					.replaceAll(" ", "")
					.replaceAll("sort$", "");
			else if (args[i].equals("-speed") && i + 1 < args.length && args[i + 1].matches("\\d+"))
				speed = Integer.parseInt(args[i + 1]);
			else if (args[i].equals("-width") && i + 1 < args.length && args[i + 1].matches("\\d+"))
				width = Integer.parseInt(args[i + 1]);
			else if (args[i].equals("-size") && i + 1 < args.length && args[i + 1].matches("\\d+"))
				size = Integer.parseInt(args[i + 1]);
			else if (args[i].equals("-buffer") && i + 1 < args.length && args[i + 1].matches("\\d+"))
				buffer = Integer.parseInt(args[i + 1]);
		}
		
		Sorting visualization = new Sorting(width, buffer);
		
		int[] array = visualization.randomize(size);
		
		// Sort the array
		if (algorithm.equals("bubble"))
			visualization.bubbleSort(array, speed);
		else if (algorithm.equals("selection"))
			visualization.selectionSort(array, speed);
		else if (algorithm.equals("quick"))
			visualization.quicksort(array, speed);
		else 
			visualization.visualize(array);
	}
	
	// Reference to the current array being drawn.
	private int[] currentArray = { 0 };
	
	// Drawing options
	private int width = 800;
	private float hue = 0.3f;
	private float saturation = 0.7f;
	private int buffer = 1;
	private int frame = 0;
	
	/**
	 * Constructs the JFrame for the sorting animation.
	 */
	public Sorting(int width, int buffer) {
		// Create the window.
		super("visual sort");
		setSize(width, 22 + width);
		
		this.width = width;
		this.buffer = buffer;
		
		// Randomize hue/saturation
		hue = (float) Math.random();
		saturation = (float) Math.random();
		
		setVisible(true);
		setResizable(false);
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
	 * Selection sort with visualization.
	 */
	public void selectionSort(int[] array, int speed) {
		selectionSort(array, true, speed);
	}
	
	/**
	 * Selection sort.
	 * @param array
	 */
	public void selectionSort(int[] array, boolean visualize, int speed) {
		for (int currentIndex = 0 ; currentIndex < array.length ; currentIndex++) {
			int minIndex = currentIndex;
			
			for (int testIndex = currentIndex + 1 ; testIndex < array.length ; testIndex++) {
				if (array[testIndex] < array[minIndex]) {
					minIndex = testIndex;
				}
			}
			
			int save = array[currentIndex];
			array[currentIndex] = array[minIndex];
			array[minIndex] = save;
			
			if (visualize)
				visualize(array, speed);
		}
	}
	
	/**
	 * Quicksort helpers.
	 */
	public void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1, false, 0);
	}
	
	// With visualization
	public void quicksort(int[] array, int speed) {
		quicksort(array, 0, array.length - 1, true, speed);
	}
	
	/**
	 * Quicksort.
	 */
	private void quicksort(int[] array, int start, int end, boolean visualize, int speed) {
		// Don't animate small intervals
		if ((end - start) * 100 < array.length)
			visualize = false;
		
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
					
					if (visualize)
						visualize(array, speed);
				}
			}
			// Swap the pivot into the center position
			array[end] = array[nextSwap];
			array[nextSwap] = pivot;
			
			// Sort the partitions on the left and right
			if (visualize)
				visualize(array, Math.min(end - start, speed * 10));
			
			quicksort(array, start, nextSwap - 1, 
				visualize, speed);
			quicksort(array, nextSwap + 1, end, 
				visualize, speed);
		}
	}
	
	/**
	 * Bubble sort helper.
	 */
	public void bubbleSort(int[] array) {
		bubbleSort(array, false, 0);
		visualize(array);
	}
	
	// With speed
	public void bubbleSort(int[] array, int speed) {
		bubbleSort(array, true, speed);
	}

	/**
	 * Bubble sort with display parameters.
	 */
	private void bubbleSort(int[] array, boolean visualize, int speed) {
		
		for (int repeat = 0 ; repeat < array.length ; repeat++) {
			// Go to every index in the list except the last one
			for (int checkIndex = 0 ; checkIndex < array.length - 1 ; checkIndex++) {
				if (array[checkIndex] > array[checkIndex + 1]) {
					// Swap if there is an unordered pair
					int save = array[checkIndex];
					array[checkIndex] = array[checkIndex + 1];
					array[checkIndex + 1] = save;
					
					if (visualize)
						visualize(array, speed);
				}
			}
			// Visualize after each pass through the list
			if (visualize)
				visualize(array, speed);
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
		frame++;
		if (frame % buffer == 0) {
			currentArray = a;
			repaint();
			
			// Optional delay
			if (delay > 0) {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	/**
	 * Draws each value in the array onto a square in the grid.
	 */
	public void paint(Graphics g) {
		int size = (int) Math.ceil(Math.sqrt(currentArray.length));
		int scale = width / size;
		
		// Go to each index in the array, and fill a square in the
		// animation with the brightness representing the magnitude of the value.
		for (int i = 0 ; i < currentArray.length ; i++ ) {
			g.setColor(Color.getHSBColor(HUE, SATURATION, currentArray[i] / 255f));
			g.fillRect((i % size) * scale, 22 + i / size * scale, scale, scale);
		}
	}
}
