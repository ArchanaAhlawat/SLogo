package backend;

import java.util.Arrays;

/**
 * Class that keeps track of the default colors
 * Allows for access to all of the colors, and changing the defaults
 * Is used in Turtle and TurtleManager
 * @author kelly
 *
 */
public class ColorManager {
	
	//these are the defaults
	private int[] BLACK = new int[] {0,0,0};
	private int[] RED = new int[] {255,0,0};
	private int[] GREEN = new int[] {0,255,0};
	private int[] BLUE = new int[] {0,0,255};
	private int[] WHITE = new int[] {255,255,255};
	private int[][] COLORS = new int[][] {new int[] {0}, BLACK, RED, GREEN, BLUE, WHITE};
	
	private int backgroundColor;
	
	/**
	 * @param index
	 * @return color at that index
	 */
	public int[] getColor(int index) {
		return COLORS[index];
	}

	/**
	 * @param currentColor
	 * @return the index of that color
	 */
	public int getIndex(int[] currentColor) {
		return Arrays.asList(COLORS).indexOf(currentColor);
	}
	
	/**
	 * edits the COLORS array
	 * @param index
	 * @param newColor
	 */
	public void setIndex(int index, int[] newColor) {
		COLORS[index] = newColor;
	}
	
	/**
	 * @return the index of the background color
	 */
	public int getBackground() {
		return backgroundColor;
	}
	
	/**
	 * sets the background color to the color at that index
	 * @param index
	 */
	public void setBackground(int index) {
		backgroundColor = index;
	}
}
