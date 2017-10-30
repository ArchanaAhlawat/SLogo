package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;

public class SetPenSize extends DisplayCommands {

	public SetPenSize(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate(){
		return currentTurtle.setPenSize(expr1);
	}
}