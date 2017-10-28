package frontend;


import controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class History extends Scroll {

	
	private static final String EMPTY_STRING = "";
	private DisplayTurtle displayTurtle;
	private ReturnValue returnValue;
	
	
	public History(String label, int x, int y, int width, int height,DisplayTurtle displayTurtle,ReturnValue returnValue) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
	
		this.displayTurtle=displayTurtle; 
		this.returnValue=returnValue;
		

	
		
	}
	
	protected void addHistory(String command) {
		if(!command.equals(EMPTY_STRING)) {
			String formattedCommand = formatCommand(command);
		    
			addToScrollPane(formattedCommand);
			
			clickable();
		}
	}
	
	protected void clickable() {
	
		Text curr=super.curr;
		System.out.println(curr.getText());
		curr.setOnMouseClicked(e -> handleMouseClick(e,displayTurtle,returnValue,curr));

     }
	
	protected void handleMouseClick(MouseEvent e,DisplayTurtle display,ReturnValue returnValue,Text current) {
		Controller myController=new Controller();
		
		String currentCommand=current.getText().trim();
		double commandValue=myController.setCommand(currentCommand);
		
		double xCor=myController.getXCor();
	
		double yCor=myController.getYCor();
	
		double theta=myController.getTheta();
	
		double turtleVis=myController.getTurtleVis();
		
		display.updateTurtle(xCor,yCor,theta,turtleVis);
		addHistory(currentCommand);
		returnValue.addReturnValue(commandValue);
       

	}
	
}
