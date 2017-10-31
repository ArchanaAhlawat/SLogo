package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * TurtcleCommands class
 * Default for the commands with one parameters needed
 * peeks the parameter, does the update and then does not need to adds it to teh stack
 * @author kelly
 *
 */
public abstract class TurtleCommandsOneParam extends GeneralCommands {

	public TurtleCommandsOneParam(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected void setParams() {
		expr1 = instructionStacks.peekDouble();
	}
	
	@Override
	protected void addReturn(double returnVal) {
		//do nothing
	}
}
