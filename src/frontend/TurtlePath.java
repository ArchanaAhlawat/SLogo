package frontend;

import java.util.List;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;


public class TurtlePath {
	public static final int X_INDEX = 0;
	public static final int Y_INDEX = 1;
	private Path path;
	private int prevPathSize;
	
	public TurtlePath(double origin_x,double origin_y) {
		path = new Path();
		prevPathSize = 0;
		path.getElements().add(new MoveTo(origin_x,origin_y));
	}
	
	protected void updatePath(List<List<Double>> start,List<List<Double>> end) {
		int currPathSize = start.size();
		if(currPathSize > prevPathSize) {
			for(int i = 0; i < start.size(); i++) {
				double startX = start.get(i).get(X_INDEX);
				double startY = start.get(i).get(Y_INDEX);
				double endX = end.get(i).get(X_INDEX);
				double endY = end.get(i).get(Y_INDEX);
				path.getElements().add(new MoveTo(startX,startY));
				path.getElements().add(new LineTo(endX,endY));
			}
		}
		else if(currPathSize == 0){
			for(PathElement e : path.getElements()) {
				path.getElements().remove(e);
			}
		}
	}
}
