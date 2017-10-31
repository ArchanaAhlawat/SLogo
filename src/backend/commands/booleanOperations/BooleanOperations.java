package backend.commands.booleanOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * BooleanOperations class
 * All operations still take two parameters that need to be popped off the stack to do the update and the result returned to the stack
 * @author kelly
 * 
 */
public abstract class BooleanOperations extends GeneralCommands {
	
	public BooleanOperations(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
}
