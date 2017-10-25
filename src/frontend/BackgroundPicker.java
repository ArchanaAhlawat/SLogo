package frontend;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class BackgroundPicker extends ColorChooser{

	public BackgroundPicker(Color color, int width, int height, Node changedNode) {
		super(color, width, height, changedNode);
		// TODO Auto-generated constructor stub
	}
	
	protected void EventHandler(Color fill,Node turtleArea) {
		if(turtleArea instanceof Display) {
			((Display) turtleArea).changeColor(fill);
		}
	}

}
