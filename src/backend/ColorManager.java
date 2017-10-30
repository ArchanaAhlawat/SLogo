package backend;

import java.util.Arrays;

public class ColorManager {
	
	//these are the defaults
	private int[] BLACK = new int[] {0,0,0};
	private int[] RED = new int[] {255,0,0};
	private int[] GREEN = new int[] {0,255,0};
	private int[] BLUE = new int[] {0,0,255};
	private int[] WHITE = new int[] {255,255,255};
	private int[][] COLORS = new int[][] {new int[] {0}, BLACK, RED, GREEN, BLUE, WHITE};
	
	public int[] getColor(int index) {
		return COLORS[index];
	}

	public double getIndex(int[] currentColor) {
		return Arrays.asList(COLORS).indexOf(currentColor);
	}
	
	public void setIndex(int index, int[] newColor) {
		COLORS[index] = newColor;
	}

}
