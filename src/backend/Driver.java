package backend;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	private List<Turtle> turtles;
	private String input;
	private List<String> instructions;
	private Parser p;
	private Turtle myTurtle;
	
	
	public Driver() {
		myTurtle = new Turtle();
		try {
			p = new Parser(myTurtle, "english");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		//turtles = new ArrayList<>();
		//turtles.add(new Turtle());
		
	
	public double setCommand(String instruction) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		p.parseInstruction(instruction);
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
