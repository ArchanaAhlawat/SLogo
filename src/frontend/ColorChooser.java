package frontend;


import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;


public abstract class ColorChooser extends ColorPicker {
	protected Color current;

	
	public ColorChooser(Color color,int width,int height, Node changedNode) {
		super(color);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
         current=color;

		this.setOnAction(e -> EventHandler(this,this.getValue(),changedNode));
	}
	
	protected void EventHandler(ColorChooser thisBP,Color fill,Node turtleArea) {
		
	}
	
	public Color getColor() {
	    System.out.println("quick test"+current);
		return current;
	}
	

}
