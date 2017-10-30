package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;

public class SetPenColor extends DisplayCommands {

	public SetPenColor(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.setPenColor((int) expr1);
	}
}