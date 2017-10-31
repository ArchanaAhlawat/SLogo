package backend.commands.miscellaneousCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * MiscellaneousCommands class
 * operations are all different and override execute
 * @author kelly
 * 
 */
public abstract class MiscellaneousCommands extends GeneralCommands {

	public MiscellaneousCommands(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
}
