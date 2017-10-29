package frontend;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class DisplayTurtle extends ImageView {
	private static final String DEFAULT_TURTLE_DIRECTORY = "src/resources/turtle.png";
	private static final double ORIGIN_X = FrontEndDriver.ORIGIN_X;
	private static final double ORIGIN_Y = FrontEndDriver.ORIGIN_Y;
	private static final double TURTLESIZE = FrontEndDriver.TURTLESIZE;
	
	private int turtID;
	private TurtlePath turtlePath;
	
	public DisplayTurtle(int ID) {
		super();
		this.setImage(setDefaultImage());
		this.setX(ORIGIN_X);
		this.setY(ORIGIN_Y);
		this.setFitWidth(TURTLESIZE);
		this.setFitHeight(TURTLESIZE);
		turtID = ID;
		turtlePath = new TurtlePath(ORIGIN_X,ORIGIN_Y);
	}
	
	private Image setDefaultImage() {
		File file = new File(DEFAULT_TURTLE_DIRECTORY);
        return new Image(file.toURI().toString());
	}
	
	protected void updateTurtle(double xCor,double yCor,double theta,double turtleVis) {
		this.setX(xCor);
		this.setY(yCor);
		this.setRotate(theta);
		this.setVisible(booleanConverter(turtleVis));
	}
	
	protected TurtlePath getPath() {
		return turtlePath;
	}
	
	protected void drawPath(List<Double> linesToDraw) {
		turtlePath.updatePath(linesToDraw);
	}
	
	protected void deactivate() {
			setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8),15,0,0,0)");
	}
	
	protected void activate() {
		setStyle("-fx-background-color:transparent");
	}
	
	protected int getID() {
		return turtID;
	}
	
	private boolean booleanConverter(double dub) {
		return (dub == 1) ? true:false;
	}

}
