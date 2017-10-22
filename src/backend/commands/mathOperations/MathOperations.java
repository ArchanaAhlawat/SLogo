package backend.commands.mathOperations;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import backend.Turtle;
import backend.commands.Command;
import backend.commands.TurtleCommands;

public class MathOperations {//implements Command {

	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;
	//https://stackoverflow.com/questions/507602/how-can-i-initialise-a-static-map
	private static final Map<String, Integer> numParams;
	static {
		Map<String, Integer> myMap = new HashMap<>();
		myMap.put("sum", 2);
		myMap.put("difference", 2);
		myMap.put("product", 2);
		myMap.put("quotient", 2);
		myMap.put("remainder", 2);
		myMap.put("minus", 1);
		myMap.put("random", 1);
		myMap.put("sin", 1);
		myMap.put("cos", 1);
		myMap.put("tan", 1);
		myMap.put("atan", 1);
		myMap.put("log", 1);
		myMap.put("pow", 2);
		myMap.put("pi", 0);
		numParams = Collections.unmodifiableMap(myMap);
	}
	
	//@Override
	public double execute(String methodName, Turtle currentTurtle) {
		//use map to go from string method to num parameters for method
		//reflection from string method to actual method
		//get parameters from parser
		//invoke method with parameters
			//method then calculates MATH operation
		//returns required double
		int parameters = numParams.get(methodName);
		
		//TODO: this try catch is in every execute...
		try {
			Method method = TurtleCommands.class.getMethod(methodName, String.class);
			//Parser.getParams(); //gets the required number of parameters as an in order array
			double[] myParams = new double[] {5.0, 10.0}; //just for right now!!
			Object returnValue = method.invoke(null, myParams);
			return (double) returnValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}
	
	private double sum(double expr1, double expr2) {
		return expr1+expr2;
	}
	
	private double difference(double expr1, double expr2) {
		return expr1-expr2;
	}
	
	private double product(double expr1, double expr2) {
		return expr1*expr2;
	}

}
