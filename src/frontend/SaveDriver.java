package frontend;

import java.io.File;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SaveDriver extends FrontEndDriver {
	
	private Color c;
	private File file;
	private String language;
	private Color penColor;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		super.start(primaryStage);

	}
	
	@Override
	protected BackgroundPicker createBackgroundPicker() {
		System.out.println(c);
		return new BackgroundPicker(c, BUTTON_WIDTH, BUTTON_HEIGHT, turtleArea);
	}
	
	public void set(Color color,File f,String language,Color penColor) {
		this.c=color;
		this.file=f;
		this.language=language;
		this.penColor=penColor;
	}
	
	@Override
	public PenPicker createPenPicker() {
		System.out.println(penColor);
		return new PenPicker(penColor, BUTTON_WIDTH, BUTTON_HEIGHT, turtlePath);
	}
	

	
	@Override
	protected DisplayTurtle createFirstTurtle() {
		return new DisplayTurtle(file);
	}
	
	@Override
	public LanguageChooser createLanguageChooser() {
		return new LanguageChooser(myResources.getString("Languages"), BUTTON_WIDTH, BUTTON_HEIGHT,language);
	}
	


}
