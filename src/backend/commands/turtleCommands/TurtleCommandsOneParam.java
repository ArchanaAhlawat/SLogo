package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.commands.GeneralCommands;

public abstract class TurtleCommandsOneParam extends GeneralCommands {

	public TurtleCommandsOneParam(Stacks myStack, Turtle myTurtle) {
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
