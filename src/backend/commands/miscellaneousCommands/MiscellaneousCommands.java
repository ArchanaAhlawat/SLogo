package backend.commands.miscellaneousCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * GeneralOperations class
 * Most operations still take two parameters that need to be popped off the stack to do the update and the result returned to the stack
 * Has static final values that are used throughout the hierarchy
 * @author kelly
 * 
 */
public abstract class MiscellaneousCommands extends GeneralCommands {

	public MiscellaneousCommands(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
}
