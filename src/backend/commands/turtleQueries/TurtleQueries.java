package backend.commands.turtleQueries;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public abstract class TurtleQueries extends GeneralCommands {

	public TurtleQueries(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected void setParams() {
		//do nothing
	}
}