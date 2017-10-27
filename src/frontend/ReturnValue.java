package frontend;

import javafx.scene.text.Text;

public class ReturnValue extends Scroll {

	public ReturnValue(String label, int x, int y, int width, int height) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	protected void addReturnValue(double value) {
		String valueS=Double.toString(value);
	
		addToScrollPane(valueS);
	}

}
