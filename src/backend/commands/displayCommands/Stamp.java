package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public class Stamp extends GeneralCommands {

	public Stamp(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.stamp());
	}
}
