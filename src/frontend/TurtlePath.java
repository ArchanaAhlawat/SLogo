package frontend;

import java.util.List;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;


public class TurtlePath extends Path{
	public static final int X_INDEX = 0;
	public static final int Y_INDEX = 1;
	private int prevPathSize;
	
	public TurtlePath(double origin_x,double origin_y) {
		super(new MoveTo(origin_x,origin_y));
		prevPathSize = 0;
	}
	
	protected void updatePath(List<List<Double>> start,List<List<Double>> end) {
		int currPathSize = start.size();
		if(currPathSize > prevPathSize) {
			for(int i = 0; i < start.size(); i++) {
				double startX = start.get(i).get(X_INDEX);
				double startY = start.get(i).get(Y_INDEX);
				double endX = end.get(i).get(X_INDEX);
				double endY = end.get(i).get(Y_INDEX);
				this.getElements().add(new MoveTo(startX,startY));
				this.getElements().add(new LineTo(endX,endY));
			}
		}
		else if(currPathSize == 0){
			for(PathElement e : this.getElements()) {
				this.getElements().remove(e);
			}
		}
	}
}
