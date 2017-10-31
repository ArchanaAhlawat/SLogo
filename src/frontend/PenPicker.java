package frontend;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class PenPicker extends ColorChooser {


	public PenPicker(Color color, int width, int height, Node changedNode) {
		super(color, width, height, changedNode);
		// TODO Auto-generated constructor stub
		current=color;
	}
	
	protected void changeTurtleAreaColor(Color fill,Node turtlePath) {
		if(turtlePath instanceof Path) ((Path) turtlePath).setFill(fill);

	}

}
