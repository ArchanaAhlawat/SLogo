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
	
	protected void addHistory(String command) {
		if(!command.equals(EMPTY_STRING)) {
			String formattedCommand = formatCommand(command);
		    
			addToScrollPane(formattedCommand);
			
			clickable();
		}
	}
	
	protected void clickable() {
	
		Text curr = super.curr;
		
		curr.setOnMouseClicked(e -> handleMouseClick(e,displayTurtleManager,returnValue,curr,myController));

     }
	
	protected void handleMouseClick(MouseEvent e,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Text current,Controller myController) {
		
		
		String currentCommand=current.getText().trim();
		double commandValue=myController.setCommand(currentCommand);
		
		double xCor=myController.getXCor();
	
		double yCor=myController.getYCor();
	
		double theta=myController.getTheta();
	
		double turtleVis=myController.getTurtleVis();
		
		displayTurtleManager.updateTurtles(xCor,yCor,theta,turtleVis);
		addHistory(currentCommand);
		displayTurtleManager.drawLines(myController.getLinestoDraw());
		returnValue.addReturnValue(commandValue);
       

	}
	
}
