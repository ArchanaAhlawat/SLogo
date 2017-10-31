package frontend;


import java.lang.reflect.InvocationTargetException;

import controller.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class History extends Scroll {

	
	protected static final String EMPTY_STRING = "";
	private DisplayTurtleManager displayTurtleManager;
	private ReturnValue returnValue;
	protected Controller myController;
	private Display turtleArea;
	
	
	public History(String label, int x, int y, int width, int height,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Controller myController,Display turtlePane) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
	
		this.displayTurtleManager=displayTurtleManager; 
		this.returnValue=returnValue;
		this.myController=myController;
		turtleArea = turtlePane;
		

	
		
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
		
		curr.setOnMouseClicked(e -> handleMouseClick(e,displayTurtleManager,returnValue,curr,myController,turtleArea));


     }
	

	protected void handleMouseClick(MouseEvent e,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Text current,Controller myController,Display turtleArea) {

		
		
		String currentCommand=current.getText().trim();
		double commandValue = 0;
		try {
			commandValue = myController.setCommand(currentCommand);
		} catch (IllegalAccessException
				| IllegalArgumentException
				| InvocationTargetException
				| NoSuchMethodException
				| SecurityException
				| InstantiationException
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		displayTurtleManager.updateTurtles(myController.getTurtles(),turtleArea);

		addHistory(currentCommand);
		returnValue.addReturnValue(commandValue);
       

	}
	
}
