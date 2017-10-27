package frontend;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.text.Text;

public class ReturnValue extends Scroll {
	private static final int LABEL_START = 5;
	private Text curr;

	
	


	public ReturnValue(String label, int x, int y, int width, int height) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
		curr=new Text("");
		curr.wrappingWidthProperty().bind(this.widthProperty());
		curr.setTranslateX(LABEL_START);
		curr.setTranslateY(20);
		super.root.getChildren().add(curr);
	}
	
	protected void addReturnValue(double value) {
		String valueS=Double.toString(value);
	
		addToScrollPane(valueS);
	}
	
	protected void addToScrollPane(String command) {
		curr.setText(command);
		
	}
	
	

}
