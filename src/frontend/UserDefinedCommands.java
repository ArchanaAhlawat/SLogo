package frontend;

import controller.Controller;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class UserDefinedCommands extends History{

	public UserDefinedCommands(String label, int x, int y,int width, int height,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Controller myController,Display turtlePane) {
		super(label, x, y, width, height,displayTurtleManager,returnValue, myController,turtlePane);
		// TODO Auto-generated constructor stub
		
		
	}

@Override
protected void handleMouseClick(MouseEvent e,DisplayTurtleManager displayTurtleManager,ReturnValue returnValue,Text current,Controller myController,Display turtleArea) {

		
		
		String currentCommand=current.getText().trim();
		double commandValue=myController.setCommand(currentCommand);

		
		displayTurtleManager.updateTurtles(myController.getTurtles(),turtleArea);

		
		returnValue.addReturnValue(commandValue);
       

	}
	
	
	
	

}
