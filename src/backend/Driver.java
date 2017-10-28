package backend;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import frontend.LanguageChooser;

public class Driver {
	
	private static final String LANGUAGE_DEFAULT = LanguageChooser.LANGUAGE_DEFAULT;
	
	private String input;
	private Parser p;
	private Turtle myTurtle;
	
	
	public Driver() {
		myTurtle = new Turtle();
		try {
			p = new Parser(LANGUAGE_DEFAULT);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public double setCommand(String instruction) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		TurtleTree t = new TurtleManager();
		p.parseInstruction(t, instruction);
		return p.getReturnVal();
	}
	
	public void setLanguage(String language) { // what? 
			try {
				p = new Parser(language);
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
