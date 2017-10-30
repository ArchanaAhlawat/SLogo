package frontend;


import javafx.scene.text.Text;

public class ReturnValue extends Scroll {
	private static final int VALUE_START_X = 0;
	private static final int VALUE_START_Y = 40;


	public ReturnValue(String label, int x, int y, int width, int height) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
		curr=new Text("");
		curr.wrappingWidthProperty().bind(this.widthProperty());
		curr.setTranslateX(VALUE_START_X);
		curr.setTranslateY(VALUE_START_Y);
	    scrollPaneRoot.getChildren().add(curr);

	}
	
	protected void addReturnValue(double value) {
		String valueS = Double.toString(value);
		addToScrollPane(valueS);
	}
	
	protected void addToScrollPane(String command) {
		curr.setText(command);
	}
	
	

}
