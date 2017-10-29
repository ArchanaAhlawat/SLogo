package frontend;


import controller.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class History extends Scroll {

	
	private static final String EMPTY_STRING = "";
	private DisplayTurtleManager displayTurtleManager;
	private ReturnValue returnValue;
	private Controller myController;
	
	
	public History(String label, int x, int y, int width, int height,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Controller myController) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
	
		this.displayTurtleManager=displayTurtleManager; 
		this.returnValue=returnValue;
		this.myController=myController;
		

	
		
	}
	
	void addHistory(String command) {
		if(!command.equals(EMPTY_STRING)) {
			String formattedCommand = formatCommand(command);
		    
			addToScrollPane(formattedCommand);
			
			clickable();
		}
	}
	
	private void clickable() {
	

		Text curr = super.curr;
		
		curr.setOnMouseClicked(e -> handleMouseClick(e,displayTurtleManager,returnValue,curr,myController));


     }
	
	private void handleMouseClick(MouseEvent e,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Text current,Controller myController) {
		
		
		String currentCommand=current.getText().trim();
		double commandValue=myController.setCommand(currentCommand);

		displayTurtleManager.updateTurtles(myController.getXCor(),myController.getYCor(),myController.getTheta(),myController.getTurtleVis());

		addHistory(currentCommand);
		displayTurtleManager.drawLines(myController.getLinestoDraw());
		returnValue.addReturnValue(commandValue);
       

	}
	
}
