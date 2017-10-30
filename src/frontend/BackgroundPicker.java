package frontend;


import java.util.LinkedList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;


public class BackgroundPicker extends ColorChooser{
	
	

	public BackgroundPicker(Color color, int width, int height, Node changedNode) {
		super(color, width, height, changedNode);
		// TODO Auto-generated constructor stub
		((Display)changedNode).changeColor(color);
	}
	
	protected void EventHandler(ColorChooser thisBP,Color fill,Node turtleArea) {
		if(turtleArea instanceof Display) {
			((Display) turtleArea).changeColor(fill);
			thisBP.current=fill;
			
		}
	}
	
	

}
