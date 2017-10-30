package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;

public class GetPenColor extends DisplayCommands {

	public GetPenColor(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getPenColor());
	}
}