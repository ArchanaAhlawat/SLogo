package backend;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Driver {
	
	private String LANGUAGE_DEFAULT="English";
	
	private String input;
	private Parser p;
	private TurtleTree myTurtleManager;
	
	
	public Driver() {
		try {
			p = new Parser(LANGUAGE_DEFAULT);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTurtleTree() { // create new turtle manager
		myTurtleManager = new TurtleManager();
	}
		
	public double setCommand(String instruction) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		p.parseInstruction(myTurtleManager, instruction);
		return p.getReturnVal();
	}
	
	public void reactivate(double id) {
		myTurtleManager.reactivateTurtle(id); // DOES THIS WORK? 
	}
	
	public void deactivate(double id) {
		myTurtleManager.deactivateTurtle(id);
	}
	
	public List<Turtle> getTurtles() {
		return myTurtleManager.getActiveTurtles();
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
		System.out.println("Xcor in BEDriver: " + new Updates(myTurtleManager).getXCor());
		return new Updates(myTurtleManager);
	}
	
	public List<Double> getLines() {
		return myTurtleManager.getLines();
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	

	
	public List<String> getUserDefinedVars() {
		return p.getUserDefinedVars();
	}
	
	public List<String> getUserDefinedCommands() {
		return p.getUserDefinedCommands();
	}
}
