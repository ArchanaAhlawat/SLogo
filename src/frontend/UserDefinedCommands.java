package frontend;

import java.lang.reflect.InvocationTargetException;

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

		
		
		String commandWord=current.getText().trim();
		
		String currentCommand1=commandWord.split(" ")[0];
		String currentCommand=currentCommand1.substring(0, currentCommand1.length() - 1);
		System.out.println(currentCommand);
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

		
		returnValue.addReturnValue(commandValue);
       

	}
	
	
	
	

}
