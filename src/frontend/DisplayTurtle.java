package frontend;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import backend.Updates;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayTurtle extends ImageView {
	private static final String XCOR = "xCor";
	private static final String YCOR = "yCor";
	private static final String HEADING = "heading";
	private static final String VISIBILITY = "visibility";
	private static final HashMap<String,Integer> UPDATEINDICES = new HashMap<String,Integer>() {{
		put(XCOR,0);
		put(YCOR,1);
		put(HEADING,2);
		put(VISIBILITY,3);
	}};
	private static final double ORIGIN_X = FrontEndDriver.ORIGIN_X;
	private static final double ORIGIN_Y = FrontEndDriver.ORIGIN_Y;
	
	public DisplayTurtle(Image image,double originX, double originY,int size) {
		super(image);
		this.setX(originX);
		this.setY(originY);
		this.setFitWidth(size);
		this.setFitHeight(size);
	}
	
	protected void updateTurtle(double xCor,double yCor,double theta,double turtleVis) {
		this.setX(xCor);
		this.setY(yCor);
		this.setRotate(theta);
		this.setVisible(booleanConverter(turtleVis));
	}
	
	private boolean booleanConverter(double dub) {
		return (dub == 1) ? true:false;
	}

}
