package backend;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	private List<Turtle> turtles;
	private String input;
	private List<String> instructions;
	
	public Driver() {
		
		turtles = new ArrayList<>();
		turtles.add(new Turtle());
		
		Parser parseInstr = new Parser();
		//instructions = parseInstr.getInstructions();
		// do instruction!!!
		
	}
	
	public void setInput(String input) {
		this.input = input;
	}

}
