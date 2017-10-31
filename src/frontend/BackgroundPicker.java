package frontend;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;


public class BackgroundPicker extends ColorPicker {

	public BackgroundPicker(Color color, int width, int height, Display turtleArea) {
		super(color);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setOnAction(e -> changeTurtleAreaColor(this.getValue(),turtleArea));
	}
	
	protected void changeTurtleAreaColor(Color fill,Display turtleArea) {
		turtleArea.changeColor(fill);
	}

}
