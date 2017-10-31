package frontend;

import java.io.File;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * DisplayTurtle class
 * Purpose: an extension of ImageView that can display the updated information of the turtle passed in from the back end 
 * Assumptions: the path for the default image for the display turtle is valid. It shall be added to the turtleArea pane
 * Example of how to use it: create a new turtle with the given ID that should be one or greater and not already used. It will appear on the screen
 * and will update given instructions from DisplayTurtleManager
 * Other details: there is a hashmap of display turtles and ID's in DisplayTurtleManager, but it is here too to be able to get a turtleID given a 
 * turtle, which is useful for reactivating or deactivating a turtle
 * @author Owen Smith
 *
 */
public class DisplayTurtle extends ImageView {
	private static final String DEFAULT_TURTLE_DIRECTORY = "src/resources/turtle.png";
	private static final double TURTLESIZE = FrontEndDriver.TURTLESIZE;
	private static final double ORIGIN_X = DisplayTurtleManager.ORIGIN_X;
	private static final double ORIGIN_Y = DisplayTurtleManager.ORIGIN_Y;
	
	private int turtID;
	private TurtlePath turtlePath;
	private BooleanProperty isActive;
	
	public DisplayTurtle(int id) {
		super();
		turtID = id;
		this.setImage(setDefaultImage());
		initializeTurtle();
	}


	private void initializeTurtle() {
		this.setX(ORIGIN_X);
		this.setY(ORIGIN_Y);
		this.setFitWidth(TURTLESIZE);
		this.setFitHeight(TURTLESIZE);
		turtlePath = new TurtlePath(ORIGIN_X,ORIGIN_Y);
		isActive = new SimpleBooleanProperty();
	}
	
	
	public DisplayTurtle(File file) {
		super();
		this.setImage(new Image(file.toURI().toString()));
		initializeTurtle();
	}
	

	
	private Image setDefaultImage() {
		File file = new File(DEFAULT_TURTLE_DIRECTORY);
        return new Image(file.toURI().toString());
	}
	
	protected void updateTurtle(double xCor,double yCor,double theta,double turtleVis,List<Double> linesToDraw) {
		setX(xCor);
		setY(yCor);
		setRotate(theta);
		setVisible(booleanConverter(turtleVis));
		drawPath(linesToDraw);
	}
	
	protected TurtlePath getPath() {
		return turtlePath;
	}
	
	protected void updateTurtlePathColor(Color color) {
		turtlePath.setStroke(color);
	}
	
	protected void activateShadow() {
		setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8),15,0,0,0)");
	}
	
	protected void activateTransparent() {
		setStyle("-fx-background-color:transparent");
	}
	
	protected int getID() {
		return turtID;
	}
	
	protected BooleanProperty getActiveProperty() {
	  return isActive;
	}
	
	protected boolean isActive() {
		return isActive.get();
	}
	
	protected void setActive(boolean active) {
		isActive.set(active);
	}
	
	private void drawPath(List<Double> linesToDraw) {
		turtlePath.updatePath(linesToDraw);
	}
	
	private boolean booleanConverter(double dub) {
		return (dub == 1) ? true:false;
	}
	
	
	


}
