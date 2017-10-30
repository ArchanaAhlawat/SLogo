package frontend;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class ColorChooser extends ColorPicker {
	
	public ColorChooser(Color color,int width,int height, Node changedNode) {
		super(color);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setOnAction(e -> changeTurtleAreaColor(this.getValue(),changedNode));
	}
	
	protected void changeTurtleAreaColor(Color fill,Node node) {
		
	}
	
}
