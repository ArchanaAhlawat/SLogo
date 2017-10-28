package backend.commands.displayCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public abstract class DisplayCommands extends GeneralCommands {

	public DisplayCommands(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

}
