package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;

public class SetPenColor extends DisplayCommands {

	public SetPenColor(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		double expr1 = instructionStacks.peekDouble();
		instructionStacks.addDouble(currentTurtle.setPenColor((int) expr1));
	}
}