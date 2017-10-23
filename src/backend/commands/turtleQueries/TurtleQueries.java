package backend.commands.turtleQueries;

import java.lang.reflect.Method;

import backend.Turtle;
import backend.api.Command;

/**
 * turtlequeries class that uses reflection to determine which method to use from the string of the method name
 * has a static map to know the number of parameters that need to be popped from the stack of values
 * not used anymore, instead each method is a class
 * 
 * @author kelly
 * 
 */
public class TurtleQueries {//implements Command {

	private static final String XCOR = "xcor";
	private static final String YCOR = "ycor";
	private static final String THETA = "theta";
	private static final String PENDOWN = "penDown";
	private static final String TURTLEVIS = "turtleVis";
	private Turtle myTurtle;
	
	//@Override
	public double execute(String methodName, Turtle currentTurtle) {
		//reflection from string method to actual method with parameters
			//gets the needed value from the turtle
			//returns required double
		myTurtle = currentTurtle;
		
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
	
	private double getXCor() {
		return myTurtle.getAbsoluteOrientation(XCOR);
	}
	
	private double getYCor() {
		return myTurtle.getAbsoluteOrientation(YCOR);
	}
	
	private double getHeading() {
		return myTurtle.getAbsoluteOrientation(THETA);
	}
	
	private int getPenDown() {
		return (int) myTurtle.getAbsoluteOrientation(PENDOWN);
	}
	
	private int getTurtleVis() {
		return (int) myTurtle.getAbsoluteOrientation(TURTLEVIS);
	}

	
	
}
