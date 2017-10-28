package frontend;

import java.util.Iterator;
import java.util.List;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;


public class TurtlePath extends Path{
	private int prevPathSize;
	private boolean isPenDown;
	
	private static final double ORIGIN_X = FrontEndDriver.ORIGIN_X;
	private static final double ORIGIN_Y = FrontEndDriver.ORIGIN_Y;
	private static final double TURTLE_SIZE = FrontEndDriver.TURTLESIZE;
	
	public TurtlePath(double origin_x,double origin_y) {
		super(new MoveTo(origin_x,origin_y));
		prevPathSize = 0;
		isPenDown = false;
	}
	
	protected void updatePath(List<Double> points) {
		int currPathSize = points.size();
		if(currPathSize > prevPathSize) {
			for(int i = prevPathSize; i < currPathSize; i += 4) {
				double startX = points.get(i);
				double startY = points.get(i + 1);
				double endX = points.get(i + 2);
				double endY = points.get(i + 3);
				this.getElements().add(new MoveTo(startX + ORIGIN_X,startY + ORIGIN_Y));
				this.getElements().add(new LineTo(endX + ORIGIN_X,endY + ORIGIN_Y));
			}
		}
		else if(currPathSize == 0){
			Iterator it = this.getElements().iterator();
			while(it.hasNext()) {
				it.next();
				it.remove();
			}
		}
	}
}
