package frontend;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SaveDriver extends FrontEndDriver {
	
	private Color c;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		super.start(primaryStage);

	}
	
	@Override
	protected BackgroundPicker createBackgroundPicker() {
		System.out.println(c);
		return new BackgroundPicker(c, BUTTON_WIDTH, BUTTON_HEIGHT, turtleArea);
	}
	
	public void setColor(Color color) {
		this.c=color;
	}
	


}
