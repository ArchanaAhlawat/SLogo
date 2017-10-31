package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public class ClearStamps extends GeneralCommands {

	public ClearStamps(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		currentTurtle.clearStamps();
	}
	
}
