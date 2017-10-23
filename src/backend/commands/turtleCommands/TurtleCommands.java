package backend.commands.turtleCommands;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import backend.Turtle;

/**
 * turtlecommands class that uses reflection to determine which method to use from the string of the method name
 * has a static map to know the number of parameters that need to be popped from the stack of values
 * not used anymore, instead each method is a class
 *
 * @author kelly
 * 
 */
public class TurtleCommands {//implements Command {
	
	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;
	private Turtle myTurtle;
	//https://stackoverflow.com/questions/507602/how-can-i-initialise-a-static-map
	private static final Map<String, Integer> numParams;
	static {
		Map<String, Integer> myMap = new HashMap<>();
		myMap.put("forward", 1);
		myMap.put("back", 1);
		myMap.put("left", 1);
		myMap.put("right", 1);
		myMap.put("setHeading", 1);
		myMap.put("setXY", 1);
		myMap.put("penDown", 0);
		myMap.put("penUp", 0);
		myMap.put("showTurtle", 0);
		myMap.put("hideTurtle", 0);
		myMap.put("home", 0);
		myMap.put("clearScreen", 0);
		numParams = Collections.unmodifiableMap(myMap);
	}
	
	//@Override
	public double execute(String methodName, Turtle currentTurtle) {
		//use map to go from string method to num parameters for method
		//get parameters from parser
		//reflection from string method to actual method with parameters
			//actual method then calculates differences
			//updates current turtle
			//returns required double
		myTurtle = currentTurtle;
		int parameters = numParams.get(methodName);
		
		try {
			Method method = TurtleCommands.class.getMethod(methodName, String.class);
			//Parser.getParams(); //gets the required number of parameters as an in order array
			double[] myParams = new double[] {5.0, 10.0}; //just for right now!!
			//TODO: make the input for each method an array...
			Object returnValue = method.invoke(null, myParams);
			return (double) returnValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0.0;
	}
	
	private double forward(double pixels) {
		myTurtle.move(pixels);
		return pixels;
	}
	
	private double back(double pixels) {
		myTurtle.move(-1*pixels);
		return pixels;
	}
	
	private double right(double pixels) {
		myTurtle.rotate(pixels);
		return pixels;
	}
	
	private double left(double pixels) {
		myTurtle.rotate(-1*pixels);
		return pixels;
	}
	
	private double setHeading(double degrees) {
		return myTurtle.setHeading(degrees);
	}

	private double setXY(double x, double y) {
		return myTurtle.setXY(x, y);
	}

	private double penDown() {
		return myTurtle.penChange(ONE);
	}

	private double penUp() {
		return myTurtle.penChange(ZERO);
	}

	private double showTurtle() {
		return myTurtle.visChange(ONE);
	}

	private double hideTurtle() {
		return myTurtle.visChange(ZERO);
	}

	private double home() {
		return myTurtle.home();
	}

	private double clearScreen() {
		return myTurtle.clearScreen();
	}
	
	/**
	 * @param absoluteOrientation
	 * @param visibleEffects
	 * @param currentTurtle
	 */
	public void turtleUpdate(double[] absoluteOrientation, boolean[] visibleEffects, Turtle currentTurtle) {
		//currentTurtle.update(double[] absoluteOrientation, boolean[] visibleEffects);
	}
	
	
	public static void main (String[] args) throws Exception {
		
	}

}
