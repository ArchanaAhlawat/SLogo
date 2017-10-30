package backend.commands.multipleTurtleCommands;

import backend.Stacks;
import backend.TurtleTree;
import backend.api.Command;
import backend.commands.GeneralCommands;

public class Turtles extends GeneralCommands {

	public Turtles(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getSize());
	}

}
