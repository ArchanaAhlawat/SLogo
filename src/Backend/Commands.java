package Backend;

public class Commands {

	private TurtleInfo updatedInfo = new TurtleInfo();
	
/*	public TurtleInfo forward(double pixels) {
		
	}*/
	
	//or this could be passed as the return value of the spei
	public TurtleInfo getUpdatedInfo() {
		return updatedInfo;
	}
}
