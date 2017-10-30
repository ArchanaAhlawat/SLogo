package frontend;

import java.io.File;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class DisplayTurtle extends ImageView {
	private static final String DEFAULT_TURTLE_DIRECTORY = "src/resources/turtle.png";
	private static final double TURTLESIZE = FrontEndDriver.TURTLESIZE;
	private static final double ORIGIN_X = DisplayTurtleManager.ORIGIN_X;
	private static final double ORIGIN_Y = DisplayTurtleManager.ORIGIN_Y;
	
	private int turtID;
	private TurtlePath turtlePath;
	
	public DisplayTurtle() {
		super();
		this.setImage(setDefaultImage());
		this.setX(ORIGIN_X);
		this.setY(ORIGIN_Y);
		this.setFitWidth(TURTLESIZE);
		this.setFitHeight(TURTLESIZE);
		turtlePath = new TurtlePath(ORIGIN_X,ORIGIN_Y);
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
		turtlePath.setFill(color);
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
	
	private void drawPath(List<Double> linesToDraw) {
		turtlePath.updatePath(linesToDraw);
	}
	
	private boolean booleanConverter(double dub) {
		return (dub == 1) ? true:false;
	}
	
	
	


}
