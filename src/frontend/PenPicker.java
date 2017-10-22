package frontend;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

public class PenPicker extends ColorChooser{

	public PenPicker(Color color, int width, int height, Node changedNode) {
		super(color, width, height, changedNode);
		// TODO Auto-generated constructor stub
	}
	
	protected void EventHandler(Paint fill,Node turtlePath) {
		if(turtlePath instanceof Path) ((Path) turtlePath).setFill(fill);
	}

}
