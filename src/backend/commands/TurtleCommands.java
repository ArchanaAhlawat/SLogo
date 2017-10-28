package backend.commands;

import backend.Stacks;
import backend.Turtle;

public abstract class TurtleCommands extends GeneralCommands {

	public TurtleCommands(Stacks myStack, Turtle myTurtle) {
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
