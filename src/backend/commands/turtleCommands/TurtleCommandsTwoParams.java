package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * TurtcleCommands class
 * Default for the commands with two parameters needed, just supers generalcommand which does this already
 * @author kelly
 *
 */
public abstract class TurtleCommandsTwoParams extends GeneralCommands {

	public TurtleCommandsTwoParams(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
}
