package backend.commands.displayCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * DisplayCommands class
 * Most operations return the input, so we peek instead of pop and do not add the result to the stack
 * @author kelly
 * 
 */
public abstract class DisplayCommands extends GeneralCommands {

	public DisplayCommands(Stacks myStack, TurtleTree myTurtle) {
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
