package backend;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	private List<Turtle> turtles;
	private String input;
	private List<String> instructions;
	private Parser p;
	
	
	public Driver() {
		Turtle turtle = new Turtle();
		p = new Parser(turtle);
	}
		//turtles = new ArrayList<>();
		//turtles.add(new Turtle());
		
	
	public double setCommand(String instruction) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		p.parseInstruction(instruction);
		return p.getReturnVal();
	}
	
	public void setInput(String input) {
		this.input = input;
	}

}
