package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public abstract class TurtleCommandsTwoParams extends GeneralCommands {

	public TurtleCommandsTwoParams(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
}
