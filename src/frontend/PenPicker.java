package frontend;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class PenPicker extends ColorPicker {

	public PenPicker(Color color, int width, int height, TurtlePath turtlePath) {
		super(color);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
	}

}
