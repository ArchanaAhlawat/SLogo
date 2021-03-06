package frontend;

import java.util.List;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;


public class TurtlePath extends Path{
	private int prevPathSize;
	
	private static final double TURTLE_SIZE = FrontEndDriver.TURTLESIZE;
	private static final double ORIGIN_X_PATH = FrontEndDriver.ORIGIN_X + TURTLE_SIZE/2;
	private static final double ORIGIN_Y_PATH = FrontEndDriver.ORIGIN_Y + TURTLE_SIZE/2;
	
	public TurtlePath(double origin_x,double origin_y) {
		super(new MoveTo(origin_x,origin_y));
		prevPathSize = 0;
	}
	
	protected void updatePath(List<Double> points) {
		int currPathSize = points.size();
		if(currPathSize > prevPathSize) {
			for(int i = prevPathSize; i < currPathSize; i += 4) {
				double startX = points.get(i);
				double startY = points.get(i + 1);
				double endX = points.get(i + 2);
				double endY = points.get(i + 3);
				getElements().add(new MoveTo(startX + ORIGIN_X_PATH,startY + ORIGIN_Y_PATH));
				getElements().add(new LineTo(endX + ORIGIN_X_PATH,endY + ORIGIN_Y_PATH));
			}
		}
		else if(currPathSize == 0){
			getElements().removeAll(getElements());
		}
	}
}
