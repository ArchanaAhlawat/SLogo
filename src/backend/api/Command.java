package backend.api;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

/**
 * Every command has an execute!
 * This interface is the very top of our hierarchy
 * @author kelly
 *
 */
public interface Command {

	/**
	 * @author kelly
	 * @author archana
	 * 
	 * executes by running the method associated with the string instruction/method name passed
	 * @param instructionStacks Stacks holding the parameters needed to execute instructions
	 * @param currentTurtle Turtle that will be updated with the change (may not be required)
	 * @return the double specified to be returned in the SLOGO specification, needed to be inserted into the stack of parameters
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws ClassNotFoundException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 */
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException;	
	
}
