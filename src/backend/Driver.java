package backend;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import frontend.DisplayTurtle;

public class Driver {
	
	private List<Turtle> turtles;
	private String input;
	private List<String> instructions;
	private Parser p;
	private Turtle myTurtle;
	private String language;
	private Turtle currentTurtle;
	
	
	public Driver() {
		myTurtle = new Turtle();
		p = new Parser(myTurtle, language);
	}
	
	public setLanguage(String lang) {
		language = lang;
	}
		//turtles = new ArrayList<>();
		//turtles.add(new Turtle());
		
	
	public double setCommand(String instruction,DisplayTurtle displayTurtle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		p.parseInstruction(instruction);
		currentTurtle = new Turtle(displayTurtle.getX(),displayTurtle.getY())
		return p.getReturnVal();
	}
	
	public Updates getTurtleUpdates() {
//		List<Double> returnValues = new ArrayList<Double>();
//		returnValues.add(myTurtle.getAbsoluteOrientation("xcor"));
//		returnValues.add(myTurtle.getAbsoluteOrientation("ycor"));
//		returnValues.add(myTurtle.getAbsoluteOrientation("theta"));
//		returnValues.add(myTurtle.getAbsoluteOrientation("turtleVis"));
//		return returnValues;
		return new Updates(myTurtle);
	}
	
	public List<Double> getLines() {
		return myTurtle.getLines();
	}
	
	public void setInput(String input) {
		this.input = input;
	}

}
