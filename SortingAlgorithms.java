
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

/**
 * A simple JFrame for visualizing sorting algorithms.
 * @author keshav (keshav@techlabeducation.com)
 */
public class Sorting extends JFrame {

	public static void main(String[] args) {

		
	}

	// Reference to the current array being drawn.
	private int[] currentArray = { 0 };

	// Drawing options
	private int width = 800;
	private float hue = 0.5f;
	private float saturation = 0.5f;
	private int buffer = 1;
	private int frame = 0;

	/**
	 * Constructs the JFrame for the sorting animation.
	 * @param width - the width of the window
	 * @param buffer - a number n such that every nth frame is drawn (default 1)
	 */
	public Sorting(int width, int buffer, float hue, float saturation) {
		// Create the window.
		super("visual sort");
		setSize(width, 22 + width);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// Store display parameters
		this.width = width;
		this.buffer = buffer;
		this.hue = hue;
		this.saturation = saturation;

		setVisible(true);
		setResizable(false);
	}

	/**
	 * Creates a random array of values, where each value is between 0 and 255.
	 * @param size - the length of the array
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
			g.setColor(Color.getHSBColor(hue, saturation, currentArray[i] / 255f));
			g.fillRect((i % size) * scale, 22 + i / size * scale, scale, scale);
		}
	}
}
