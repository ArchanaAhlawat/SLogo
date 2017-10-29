package frontend;

import java.io.File;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class DisplayTurtle extends ImageView {
	private static final String DEFAULT_TURTLE_DIRECTORY = "src/resources/turtle.png";
	private static final double ORIGIN_X = FrontEndDriver.ORIGIN_X;
	private static final double ORIGIN_Y = FrontEndDriver.ORIGIN_Y;
	private static final double TURTLESIZE = FrontEndDriver.TURTLESIZE;
	private static final double TURTLESIZE_GROWTH = TURTLESIZE/2;
	private static final String ACTIVETURTLE_BORDER_DIRECTORY = "resources/ActiveTurtleBorder.css";
	
	private int turtID;
	private boolean isActive;
	private TurtlePath turtlePath;
	private BooleanProperty imageViewBorderActive;
	
	public DisplayTurtle(int ID) {
		super();
		this.setImage(setDefaultImage());
		this.setX(ORIGIN_X);
		this.setY(ORIGIN_Y);
		this.setFitWidth(TURTLESIZE);
		this.setFitHeight(TURTLESIZE);
		setUpBorder();
		turtID = ID;
		turtlePath = new TurtlePath(ORIGIN_X,ORIGIN_Y);
	}
	
	private Image setDefaultImage() {
		File file = new File(DEFAULT_TURTLE_DIRECTORY);
        return new Image(file.toURI().toString());
	}
	
	protected void updateTurtle(double xCor,double yCor,double theta,double turtleVis) {
		this.setX(xCor + ORIGIN_X);
		this.setY(yCor + ORIGIN_Y);
		this.setRotate(theta);
		this.setVisible(booleanConverter(turtleVis));
	}
	
	protected TurtlePath getPath() {
		return turtlePath;
	}
	
	protected void drawPath(List<Double> linesToDraw) {
		turtlePath.updatePath(linesToDraw);
	}
	
	protected void changeTurtleActivity(List<DisplayTurtle> activeTurtles) {
		if(activeTurtles.contains(this))  {
			activeTurtles.remove(this);
		}
		else {
			activeTurtles.add(this);
		}
		imageViewBorderActive.set(!imageViewBorderActive.get());
	}
	
	protected int getID() {
		return turtID;
	}
	
	private void setUpBorder() {
		PseudoClass imageViewBorder = PseudoClass.getPseudoClass("border");
		BorderPane imageViewWrapper = new BorderPane(this);
	    imageViewWrapper.getStyleClass().add(ACTIVETURTLE_BORDER_DIRECTORY);
	    imageViewBorderActive = new SimpleBooleanProperty() {
	        @Override
	        protected void invalidated() {
	            imageViewWrapper.pseudoClassStateChanged(imageViewBorder, get());
	        }
	    };
	    BorderPane root = new BorderPane(imageViewWrapper);
	    root.setPadding(new Insets(15));
	}
	
	private boolean booleanConverter(double dub) {
		return (dub == 1) ? true:false;
	}
	
	
	


}
