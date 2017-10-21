package backend.commands;

import java.lang.reflect.Method;

import backend.Command;
import backend.Turtle;

public class TurtleQueries implements Command {

	@Override
	public double execute(String methodName, Turtle currentTurtle) {
		//reflection from string method to actual method with parameters
			//gets the needed value from the turtle
			//returns required double
		try {
			Method method = TurtleQueries.class.getMethod(methodName, String.class);
			//no parameters needed
			Object returnValue = method.invoke(null);
			return (double) returnValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}
	
	
	
}
